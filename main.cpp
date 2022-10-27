#include <iostream>
using namespace std;
#include <stdlib.h>
#include <cstdlib>

#define colA 4	//Define Column A 
#define colB 4	//Define Column B
#define rowA 4	//Define Row A
#define rowB 4	//Define Row B
#define colOut	4//Define output Column
#define rowOut	4//Define Row Column

void print(int output[][colOut]);
void classicMult(int A[][colA], int B[][colB], int output[][colOut]);
int main() {
// MAIN METHOD TESTING METHOD
//	int random = rand();
//	cout << random;
//	cout << "\n";

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
	int output[rowOut][colOut];
	 classicMult(A, B, output);
	 print(output);

	system("pause");
	return 0;

}

void classicMult(int A[][colA], int B[][colB], int output[][colOut])
{
	int currentvalue;
//	int output[rowA][colB];

	for (int i = 0; i < rowA; i++) {
		for (int j = 0; j < colB; j++) {
			output[i][j] = 0;

			for (int k = 0; k < rowB; k++) {
				currentvalue = A[i][k] * B[k][j];
				output[i][j] = currentvalue + output[i][j];
			}
		}
	}
}

void print(int output[][colOut]) {
	for (int i = 0; i < rowOut; i++) {
		for (int j = 0; j < colOut; j++) {
			printf("%d\t", output[i][j]);
		}
		printf("\n");
	}


}
