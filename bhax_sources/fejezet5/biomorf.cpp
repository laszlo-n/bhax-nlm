#include <iostream>
#include <png++/png.hpp>
#include <limits.h>
#include <omp.h>
#include <complex>

#define MERET 4096

typedef unsigned char uchar;

void mandel(uchar *&kepadat)
{
    // értelmezési tartomány kijelölése (itt: teljes mandelbrot)
    double a = -2.0, b = 2.0, c = -2.0, d = 2.0;

    // értelmezési tartomány - viewport mapping
    double dx = (b - a) / MERET; // ennyi lépcsőkben haladunk x mentén
    double dy = (d - c) / MERET; // ennyi lépcsőkben haladunk y mentén

    // definiálunk egy saját sugarat 2 helyett
    double sugar = 10.0;

    // végigcsörtetünk minden soron
    #pragma omp parallel for collapse(2)
    for(int i = 0; i < MERET; ++i)
    {
        // végigcsörtetünk minden oszlopon
        for(int j = 0; j < MERET; ++j)
        {
            // most a z (reZ, imZ) lesz az adott pixelnek megfelelő komplex szám
            // absz. min. + rel. x offset
            // absz. max. - rel. y offset (mert bal felső sarokból a jobb alsóba tartunk)
            std::complex<double> z (a + j * dx, d - i * dy);

            // választunk egy komplex számot amin kiértékeljük ezt a hibás Julia-halmazt (biomorfot)
            std::complex<double> c (.285, .0);

            // iteráció számának nyomonkövetése
            uchar iteracio = 0;

            // itt most mást csinálunk picit
            while((std::real(z) <= sugar || std::imag(z) <= sugar) && iteracio < UCHAR_MAX)
            {
                // egylépésben elvégzi az új z komponenseinek a kiszámítását,
                // és a c komponensenkénti hozzáadását az új z-hez
                z = z * z * z + c;

                // az iteráció számolásával fogjuk belőni a pixel színét
                // max iterációnál világítani fog, alacsony iterációnál meg nem
                ++iteracio;
            }

            // beleírjuk az elkészült pixelt a framebufferbe
            kepadat[i*MERET + j] = iteracio;
        }
    }
}

int main(int argc, char *argv[])
{
    // argumentum sanity check
    if(argc != 2)
    {
        std::cout << "Hasznalat: ./mandelpng \"fajlnev\"" << std::endl;
        return -1;
    }

    // framebuffer előkészítése és mandelbrot rárajzolása
    uchar *kepadat = new uchar[MERET*MERET];
    mandel(kepadat);

    // png buffer előkészítése
    png::image < png::rgb_pixel > kep(MERET, MERET);

    // minden sor bejárása
    #pragma omp parallel for collapse(2)
    for(int i = 0; i < MERET; ++i)
    {
        // minden oszlop bejárása
        for(int j = 0; j < MERET; ++j)
        {
            // picit máshogy színezgetünk most
            kep.set_pixel(j, i, png::rgb_pixel( (kepadat[i*MERET + j] * 20) % 255,
                                                (kepadat[i*MERET + j] * 40) % 255,
                                                (kepadat[i*MERET + j] * 60) % 255));
        }
    }

    // memória felszabadítása
    delete [] kepadat;

    // lemezre szerializálás és nyugtázás
    kep.write(argv[1]);
    std::cout << argv[1] << " elmentve." << std::endl;
}