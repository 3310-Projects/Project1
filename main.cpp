#include <iostream>
using namespace std;
#include <stdlib.h>


void classicMult(int A[][4], int B[][4]);
int main() {
// MAIN METHOD TESTING METHOD
	

	int A[4][4] = {
		{6,5,3,4},
		{1,2,4,5},
		{5,4,2,3},
		{1,2,4,5}
	};
	int B[4][4] = {
		{1,2,4,5},
		{5,4,2,3},
		{1,3,4,2},
		{6,5,3,4}
	};

	 classicMult(A, B);

	system("pause");
	return 0;

}

void classicMult(int A[][4], int B[][4])
{
	int output[4][4];

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			output[i][j] = 0;

			for (int k = 0; k < 4; k++) {
				output[i][j] += A[i][k] * B[k][j];
			}

			printf("%d\t", output[i][j]);
		}

		printf("\n");
	}


	cout << "\nfunction called\n";
}
