#include <stdio.h>
#include <math.h>

void kiir(double tomb[], int db)
{
	// egy tömb tartalmát sorokba listázza
	for (int i = 0; i < db; ++i) printf("%f\n", tomb[i]);
}

double tavolsag(double PR[], double PRv[], int n)
{
	double osszeg = 0;
	
	// a PRv tömb minden eleméből kivonja a PR tömb minden elemét,
	// és négyzetösszeget készít
	for (int i = 0; i < n; ++i)	osszeg += pow((PRv[i] - PR[i]), 2);
	
	return sqrt(osszeg);
}

void pagerank(double T[4][4])
{
	double PR[4] = { 0.0, 0.0, 0.0, 0.0 }; // ebbe megy az eredmény
	double PRv[4] = { 0.25, 0.25, 0.25, 0.25 }; // ezzel szorzok
		
	for (;;)
	{	
		// ide jön a mátrixművelet		
		
		for (int i = 0; i < 4; i++)
		{
			PR[i] = 0.0;
			for (int j = 0; j < 4; j++)
			{
				PR[i] = PR[i] + T[i][j] * PRv[j];
			}
		}
	
		if (tavolsag(PR, PRv, 4) < 0.0000000001) break;
		
		// ide meg az átpakolás PR-ből PRv-be
			
		for (int i = 0; i < 4; i++)
		{
			PRv[i] = PR[i];
		}	
	}
	
	kiir (PR, 4);
}

int main(void)
{
	double L[4][4] = {
		{0.0,  0.0,      1.0/3.0,  0.0},
		{1.0,  1.0/2.0,  1.0/3.0,  1.0},
		{0.0,  1.0/2.0,  0.0,      0.0},
		{0.0,  0.0, 	 1.0/3.0,  0.0}
	};	
	
	printf("\nAz eredeti mátrix értékeivel történő futás:\n");
	pagerank(L);

	return 0;
}