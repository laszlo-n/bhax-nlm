#include <stdio.h>

int main(void)
{
	int szam1 = 20, szam2 = 40;
	printf("Csere elott:\n\nszam1: %d\nszam2: %d\n\n", szam1, szam2);
	szam1 += szam2; // szam1: 20 -> 20 + 40 = 60
	szam2 = szam1 - szam2; // szam2: 40 -> 60 - 40 = 20
	szam1 -= szam2; // szam1: 60 -> 60 - 20 = 40
	printf("Csere utan:\n\nszam1: %d\nszam2: %d\n\n", szam1, szam2);
	return 0;
}