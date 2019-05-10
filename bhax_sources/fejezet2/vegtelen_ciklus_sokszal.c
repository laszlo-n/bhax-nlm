#include <omp.h>

int main(void)
{
	#pragma omp parallel for
	for (;;) ;
	return 0;
}