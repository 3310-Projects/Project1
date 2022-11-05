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
int A2[][] = {   {0,1,6,3,4,5,5,5 },
                {-2,8,7,1,3,4,5, 9},
                {2, 0, -1, 0,3,5,6,4},
                {-2,8,7,1,3,5,7,8},
                {-2,8,7,1,3,4,5,6},
                {-2,8,7,1,4,6,8,5},
                {-2,8,7,1,5,7,3,2},
                {9,1,6,-2,7,5,3,5}
              };

    int B2[][] = { {0,1,6,3,4,5,5,5 },
                  {-2,8,7,1,3,4,5, 9},
                  {2, 0, -1, 0,3,5,6,2},
                  {-2,8,4,1,3,5,7,8},
                  {-2,8,4,1,3,4,5,6},
                  {-2,8,4,1,4,6,8,5},
                  {-2,8,40,1,5,7,3,2},
                  {9,1,6,-2,7,5,3,5}
                };
    
  
    // int output[][]= new int[i][j];	                           

/////////////tests////////////////
   
    int output[][] =  divideAndConquer2(A, B, 0, 0, 0, 0, A.length);
    print(output);
    System.out.println();
    int output2[][] =  divideAndConquer2(A2, B2, 0, 0, 0, 0, A2.length);
    print(output2);

    }
///////////////////////////////



 ////////multiply method 1
 ///////////////
    public static int[][] multiplyMatric(int A[][], int B[][])
    {
        
        // int aRow = 4;
        // int aCol = 4;
        // int bRow = 4;
        int n = A.length;
        int[][] output = new int[n][n];

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                output[i][j] = 0;
                for (int k = 0; k < n; k++) 
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

public static int[][]  divideAndConquer2(int A[][], int B[][], int rowA, int colA, 
                                                        int rowB, int colB, int n)
    {
        // n = A.length;
        int C[][]= new int[n][n];
        if (n==1)               //base case
        {
            // C = multiplyMatric(A, B);
            C[0][0]= A[rowA][colA]*B[rowB][colB];
        }

        else
        {
            int nhalf = n/2;
            int[][] c11 = divideAndConquer2(A, B, rowA, colA, rowB, colB, nhalf);
            int[][] c1a = divideAndConquer2(A, B, rowA, colA + nhalf, rowB + nhalf, colB, nhalf); ///,0 ,0
            combinedMatrix(C, c11, c1a, 0, 0);

            int[][] c21 =divideAndConquer2(A, B, rowA, colA, rowB, colB, nhalf);
            int[][] c2a =divideAndConquer2(A, B, rowA, colA + nhalf, rowB, colB+nhalf, nhalf); //0, nhalf);
            combinedMatrix(C, c21, c2a, 0, nhalf);

            int[][] c12 =divideAndConquer2(A, B, rowA + nhalf, colA, rowB, colB, nhalf);
            int[][] c12a =divideAndConquer2(A, B, rowA + nhalf, colA + nhalf, rowB + nhalf, colB, nhalf);// nhalf, 0);
            combinedMatrix(C, c12, c12a, nhalf, 0);


            int[][] c22 =divideAndConquer2(A, B, rowA + nhalf, colA, rowB, colB+ nhalf, nhalf);
            int[][] c22a =divideAndConquer2(A, B, rowA + nhalf, colA+ nhalf, rowB+ nhalf, colB+ nhalf, nhalf);// nhalf, nhalf);
            combinedMatrix(C, c22, c22a, nhalf, nhalf);
        }
        return C;
    
    }
    private static void combinedMatrix(int C[][], int A[][], int B[][], int rowC, int colC)
    {
        int n = A.length;
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                C[i+rowC][j+colC] = A[i][j] + B[i][j];
            }
        }
    }


}
