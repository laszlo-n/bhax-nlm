#include <stdio.h>
#include <curses.h>
#include <unistd.h>

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

        if (xcurrent >= xmax - 1 || xcurrent <= 0) xoffset *= -1; // vízszintes boundary check
        if (ycurrent >= ymax - 1 || ycurrent <= 0) yoffset *= -1; // függőleges boundary check
    }
    
    return 0;
}