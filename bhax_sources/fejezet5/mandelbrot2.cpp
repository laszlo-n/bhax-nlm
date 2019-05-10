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

    // végigcsörtetünk minden soron
    #pragma omp parallel for collapse(2)
    for(int i = 0; i < MERET; ++i)
    {
        // végigcsörtetünk minden oszlopon
        for(int j = 0; j < MERET; ++j)
        {
            // c (reC, imC) az adott pixelnek megfelelő komplex szám
            // absz. min. + rel. x offset
            // absz. max. - rel. y offset (mert bal felső sarokból a jobb alsóba tartunk)
            std::complex<double> c (a + j * dx, d - i * dy);

            // z (reZ, imZ) a függvényérték, kezdeti értéke 0
            std::complex<double> z (0, 0);

            // iteráció számának nyomonkövetése
            uchar iteracio = 0;

            // amíg nem haladtuk meg az iterációs határt ill. nem tartunk "végtelenhez",
            // azaz a z nagysága <= 2 (a z benne van a mandelbrot halmazban), addig megyünk.
            // itt most std::abs()-t használunk ennek a mérésére, mert std::complex esetén kényelmesebb
            // így viszont ugye 2-höz kell hasonlítanunk, nem 4-hez
            while(std::abs(z) <= 2 && iteracio < UCHAR_MAX)
            {
                // egylépésben elvégzi az új z komponenseinek a kiszámítását,
                // és a c komponensenkénti hozzáadását az új z-hez
                z = z * z + c;

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
            // invertálás mert úgy szebb és feltöltés; rgb mert csak.
            kep.set_pixel(j, i, png::rgb_pixel( 255 - kepadat[i*MERET + j],
                                                255 - kepadat[i*MERET + j],
                                                255 - kepadat[i*MERET + j]));
        }
    }

    // memória felszabadítása
    delete [] kepadat;

    // lemezre szerializálás és nyugtázás
    kep.write(argv[1]);
    std::cout << argv[1] << " elmentve." << std::endl;
}