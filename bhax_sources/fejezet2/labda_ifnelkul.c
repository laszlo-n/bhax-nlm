#include <stdio.h>
#include <curses.h>
#include <unistd.h>
#include <math.h>

int main (void)
{
    WINDOW *ablak;
    ablak = initscr();

    int xcurrent = 0, ycurrent = 0;
    int xoffset = 1, yoffset = 1;
    int xmax, ymax;

    for (;;)
    {
        clear();

        getmaxyx(ablak, ymax, xmax);
        mvprintw(ycurrent, xcurrent, "O");

        refresh();
        usleep(33330);

        xcurrent += xoffset;
        ycurrent += yoffset;

        // ha valamelyik szélen van az új koordináta, az offset a következő fordulóban -1 * 1-gyel
        // lesz szorozva, azaz megfordul a "labda" megfelelő koordinátájú irányvektora
        // WARNING: bugos lehet 1-nél különbözőbb offsettel és nem (0, 0) vagy (max - 1, max - 1) indítás esetén
        xoffset *= pow(-1, (xcurrent / (xmax - 1) + ((xmax - 1) - xcurrent) / (xmax - 1)));
        yoffset *= pow(-1, (ycurrent / (ymax - 1) + ((ymax - 1) - ycurrent) / (ymax - 1)));
    }
    
    return 0;
}