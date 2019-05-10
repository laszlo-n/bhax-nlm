#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

typedef struct binfa
{
    int ertek;
    struct binfa *bal_nulla;
    struct binfa *jobb_egy;
} BINFA, *BINFA_PTR;

BINFA_PTR uj_elem(int ertek)
{
    BINFA_PTR p; // itt lesz az új elemünkre mutató pointer

    // lefoglalunk neki memóriát a heap-en
    if ((p = (BINFA_PTR) malloc(sizeof(BINFA))) == NULL)
    {
        perror("Memoria-lefoglalasi hiba.\n");
        exit(EXIT_FAILURE);
    }

    // inicializáljuk a tartalmát
    p -> ertek = ertek;
    p -> bal_nulla = p -> jobb_egy = NULL;

    // visszaadjuk
    return p;
}

void freePostorder(BINFA_PTR elem)
{
    if (elem != NULL)
    {
        freePostorder(elem -> bal_nulla);
        freePostorder(elem -> jobb_egy);
        free(elem);
    }
}

void printInorder(BINFA_PTR elem)
{
    if (elem != NULL)
    {
        printInorder(elem -> bal_nulla);
        printf("%d", elem -> ertek);
        printInorder(elem -> jobb_egy);
    }
}

int main(int argc, char **argv)
{
    // buffer, mindig a soron következő bemeneti karaktert tartalmazza
    unsigned char b;

    // fa gyökerének a létrehozása
    BINFA_PTR gyoker = uj_elem('/');

    // fa pointer beállítása a fa gyökerére / tetejére
    BINFA_PTR fa = gyoker;

    // beolvasás a stdin-ről, karakterenként (u8)
    while (read(fileno(stdin), (void *) &b, sizeof(b)))
    {
        // az alapján, hogy a beolvasott bájt a kevesebb-e mint egy bájtban eltárolható
        // maximális érték fele, vagy több-e, 0-t vagy 1-t írunk a fába
        if (b < 128)
        {
            // ha még nincs ilyen elem (bal oldali levél) a fa adott pontján, csinálunk
            if (fa -> bal_nulla == NULL)
            {
                fa -> bal_nulla = uj_elem(0); // elem init
                fa = gyoker; // fa pointer reset a fa tetejére
            }

            // ha már van, akkor meg odalépünk
            else
            {
                fa = fa -> bal_nulla;
            }
        }

        else
        {
            // ha még nincs ilyen elem (jobb oldali levél) a fa adott pontján, csinálunk
            if (fa -> jobb_egy == NULL)
            {
                fa -> jobb_egy = uj_elem(1); // elem init
                fa = gyoker; // fa pointer reset a fa tetejére
            }

            // ha már van, akkor meg odalépünk
            else
            {
                fa = fa -> jobb_egy;
            }
        }
    }

    printInorder(gyoker);
    freePostorder(gyoker);
    printf("\ndone\n");
    return 0;
}