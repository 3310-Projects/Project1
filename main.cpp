#include <iostream>
#include <stdlib.h>
#include <cstdlib>
#include <ctime>
using namespace std;

#define aRow 4		//Define A Row
#define aCol 4		//Define A Column 
#define bRow 4		//Define B Row
#define bCol 4		//Define B Column
#define outRow 4	//Define Output Row
#define outCol 4	//Define Output Column


void print(int output[][outCol]);
void classicMult(int A[][aCol], int B[][bCol], int output[][outCol]);
int main() {
// MAIN METHOD TESTING METHOD

//random number generator for arrays
/*	srand(time(0));  // Initialize random number generator
	int A[aRow][aCol];
	for (int i = 0; i < aRow; i++) {
		for (int j = 0; j < aCol; j++) {
			A[i][j] = (rand() % 10);
		}
	}
	int B[bRow][bCol];
	for (int i = 0; i < bRow; i++) {
		for (int j = 0; j < bCol; j++) {
			B[i][j] = (rand() % 10);
		}
	}
	cout << "Arrays successfully generated\n";
	*/
	
//testing arrays
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


	int output[outRow][outCol];		//specify output of matrix multiplication
	 classicMult(A, B, output);
	 print(output);




	system("pause");
	return 0;

}

void classicMult(int A[][aCol], int B[][bCol], int output[][outCol])
{
	int currentvalue;

	for (int i = 0; i < aRow; i++) {
		for (int j = 0; j < aCol; j++) {
			output[i][j] = 0;

			for (int k = 0; k < bRow; k++) {
				currentvalue = A[i][k] * B[k][j];
				output[i][j] = currentvalue + output[i][j];
			}
		}
	}
}

void print(int output[][outCol]) {
	for (int i = 0; i < outRow; i++) {
		for (int j = 0; j < outCol; j++) {
			printf("%d\t", output[i][j]);
		}
		printf("\n");
	}
}
