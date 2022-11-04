public class divideandconquer 
{
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException
    {
    int A[][] = {      {2,0,-1,6 },
                       {3,7,8,0},
                       {-5,1,6,-2},
                       {0,8,1,7}
                };
   int B[][] = {      {0,1,6,3 },
                       {-2,8,7,1},
                       {2, 0, -1, 0},
                       {9,1,6,-2}
                };
// int A[][] = { {0,1,6,3,4,5,5,5 },
//                 {-2,8,7,1,3,4,5, 9},
//                 {2, 0, -1, 0,3,5,6},
//                 {-2,8,7,1,3,5,7,8},
//                 {-2,8,7,1,3,4,5,6},
//                 {-2,8,7,1,4,6,8,5},
//                 {-2,8,7,1,5,7,3,2},
//                 {9,1,6,-2,7,5,3,5}
//               };

//     int B[][] = { {0,1,6,3,4,5,5,5 },
//                   {-2,8,7,1,3,4,5, 9},
//                   {2, 0, -1, 0,3,5,6},
//                   {-2,8,7,1,3,5,7,8},
//                   {-2,8,7,1,3,4,5,6},
//                   {-2,8,7,1,4,6,8,5},
//                   {-2,8,7,1,5,7,3,2},
//                   {9,1,6,-2,7,5,3,5}
//                 };
    
  
    // int output[][]= new int[i][j];	

/////////////tests////////////////
    // multiplyMatric(A, B);

    // output = multiplyMatrices(A, B);
    int output[][] =  divideAndConquer(A, B, 0, 0, 0, 0, A.length);
    // print(output);
    //  output=matrixMultiplication(A, B);
     print(output);
    }
///////////////////////////////

// public static int[][] matrixMultiplication(int[][] A, int[][] B){

//     return  divideAndConquer(
//             A, B, 0, 0, 
//             0,0, A.length);

// }


 ////////multiply method 1
 ///////////////
    public static int[][] multiplyMatric(int A[][], int B[][])
    {
        
        // int aRow = 4;
        // int aCol = 4;
        // int bRow = 4;
        int row = A.length;
        int col = B.length;
        int[][] output = new int[row][col];

        for (int i = 0; i < row; i++) 
        {
            for (int j = 0; j < col; j++) 
            {
                output[i][j] = 0;
                for (int k = 0; k < row; k++) 
                {  
                    output[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return output;
    }
    //////////////


    ////////// print
    public static void print(int output[][]) 
    {
        // int outCol = output.length;
        // int outRow = output.length;
        for (int i = 0; i < output.length; i++) 
        {
            for (int j = 0; j < output[0].length; j++) 
            {
                System.out.printf("%d\t", output[i][j]);
            }
            System.out.print("\n");
        }
    }
    /////////////



    //////////////divide and conquer approach
    public static int[][]  divideAndConquer(int A[][], int B[][], int rowA, int colA, 
    int rowB, int colB, int n)
    {
        // n = A.length;
        int C[][]= new int[n][n];
        if (n==4)               //base case
        {
            C = multiplyMatric(A, B);
        }

        else
        {
            int nhalf = n/2;
            combinedMatrix(C, divideAndConquer(A, B, rowA, colA, rowB, colB, nhalf),
                    divideAndConquer(A, B, rowA, colA + nhalf, rowB + nhalf, colB, nhalf),0,0);
            
            combinedMatrix(C, divideAndConquer(A, B, rowA, colA, rowB, colB, nhalf),
                    divideAndConquer(A, B, rowA, colA + nhalf, rowB, colB+nhalf, nhalf), 0, nhalf);

            combinedMatrix(C, divideAndConquer(A, B, rowA + nhalf, colA, rowB, colB, nhalf),
                    divideAndConquer(A, B, rowA + nhalf, colA + nhalf, rowB + nhalf, colB, nhalf), nhalf, 0);

            combinedMatrix(C, divideAndConquer(A, B, rowA + nhalf, colA, rowB, colB+ nhalf, nhalf),
                    divideAndConquer(A, B, rowA + nhalf, colA+ nhalf, rowB+ nhalf, colB+ nhalf, nhalf), nhalf, nhalf);
        }
        return C;
    
    }
    private static void combinedMatrix(int C[][], int A[][], int B[][], int rowC, int colC)
    {
        int n = B.length;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                C[i+rowC][j+colC] = A[i][j] + B[i][j];
            }
        }
    }
/////////////////


// multiply method 2
///////////////

    static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] result = new int[firstMatrix.length][secondMatrix[0].length];
    
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
    
        return result;
    }
    static int multiplyMatricesCell(int[][] firstMatrix, int[][] secondMatrix, int row, int col) {
       int  cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }
////////////////////
}
