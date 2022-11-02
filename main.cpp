#include <iostream>
#include <stdlib.h>
#include <cstdlib>
#include <ctime>
using namespace std;
#include <chrono>
using namespace std::chrono;
#define aRow 2		//Define A Row
#define aCol 2		//Define A Column 
#define bRow 2		//Define B Row
#define bCol 2		//Define B Column
#define outRow 2	//Define Output Row
#define outCol 2    //Define Output Column


void print(int output[][outCol]);
void classicMult(int A[][aCol], int B[][bCol], int output[][outCol]);
int main() {
	// MAIN METHOD TESTING METHOD

	//random number generator for arrays
		srand(time(0));  // Initialize random number generator
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



    auto start = high_resolution_clock::now();
	int output[outRow][outCol];		//specify output of matrix multiplication
	classicMult(A, B, output);
    auto stop = high_resolution_clock::now();
    auto duration = duration_cast<microseconds>(stop - start);
    cout << "Naive Multiplication Completed\n";
    cout << "Runtime: " << duration.count() << " microseconds" << endl;
 


//	print(output);




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

void strassenMult(int A[][aCol], int B[][bCol], int output[][outCol]) {


}

void print(int output[][outCol]) {
	for (int i = 0; i < outRow; i++) {
		for (int j = 0; j < outCol; j++) {
			printf("%d\t", output[i][j]);
		}
		printf("\n");
	}
}
