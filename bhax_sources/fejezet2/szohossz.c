#include <stdio.h>

int main(void)
{
	int hossz = 0; // hány bites az int, nem számít ennek a típusa
	int pivot = 0x1; // jelzőbit a storage space végére, ennek számít a típusa
	do
	{
 		hossz++;
	} while (pivot <<= 1); // bitwise balra tolás 1-gyel

	printf("A szohossz ezen a gepen: %d bites\n", hossz);

	return 0;
}