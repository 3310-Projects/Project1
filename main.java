

class Matrix {
    public int size = 4;
    
    public static void main(String[] args) {
        Matrix m = new Matrix();
        
        int size = 4;
        int outputSize = 8;
        int [][]A = {
            {1,2,3,4},
            {3,4,5,6},
            {1,2,3,4},
            {3,4,5,6}
        };
        int [][]B = {
            {1,2,3,4},
            {3,4,5,6},
            {1,2,3,4},
            {3,4,5,6}
        };
        int [][]A2 = {
            {1,2},
            {3,4}
        };
        int [][]B2 = {
            {1,2},
            {3,4}
        };

        int [][] testOutput = new int[outputSize][outputSize];
        m.merge(A, testOutput, 0, 0);
        m.merge(A, testOutput, 0, outputSize/2);
        m.merge(A, testOutput, outputSize/2, 0);
        m.merge(A, testOutput, outputSize/2, outputSize/2);
        int [][] testOutput2 = new int[size][size];
        m.split(A, testOutput2, 0, 0);
        /////////////PRINT///////////////////
        for(int i = 0; i < testOutput.length; i++){
            for(int j = 0; j < testOutput.length; j++){
                System.out.print(testOutput[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < testOutput2.length; i++){
            for(int j = 0; j < testOutput2.length; j++){
                System.out.print(testOutput2[i][j] + " ");
            }
            System.out.println();
        }
 
    
        
    }
    
    
    
    public int[][] strassen(int[][]A, int[][]B){
        int[][] output = new int[size][size];
        if(size == 1){
            output[0][0] = A[0][0] * B[0][0];
        }else{
            int newSize = size/2;
            int[][] a,b,c,d,e,f,g,h = new int[newSize][newSize];
  

 /*         split(A, A11, 0, 0);
            split(B, B11, 0, 0);
            split(A, A12, 0, size / 2);
            split(B, B12, 0, size / 2);
            split(A, A21, size / 2, 0);
            split(B, B21, size / 2, 0);
            split(A, A22, size / 2, size / 2);
            split(B, B22, size / 2, size / 2);
   */         
            
    
        }
    
        return output;
    }
    public int[][] classicMult(int [][] A, int [][] B){
        int n = A.length;
        int[][] productArray  = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    productArray[i][j] += A[i][k] * B[k][j];     
                }
            }
        }
        return productArray;  
    }
    
    public int[][] add(int[][] A, int[][] B){
        int n = A.length;
        int [][] resultArray = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                resultArray[i][j] = A[i][j] + B[i][j];
            }
        }
        return resultArray;
    }
    public int[][] subtract(int[][] A, int[][] B){
        int n = A.length;
        int [][] resultArray = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                resultArray[i][j] = A[i][j] - B[i][j];
            }
        }
        return resultArray;
    }

    public void merge(int[][] matrixToMerge, int[][] resultMatrix, int startingRow, int startingColumn){
        int n = matrixToMerge.length;
        for (int i = 0 ; i < n; i++ ){
            for (int j = 0; j < n; j++){
                resultMatrix[startingRow][startingColumn] = matrixToMerge[i][j];
                startingColumn++;
            }
            startingColumn -= n;
            startingRow++;
        }
    }

    public void split(int[][] matrixToSplit, int[][] resultMatrix, int startingRow, int startingColumn){ 
        int n = resultMatrix.length;
        for (int i = 0; i < n; i++){

            for (int j = 0; j < n; j++){
 
                resultMatrix[i][j] = matrixToSplit[startingRow][startingColumn];
                startingColumn++;
            }
            startingColumn -= n;
            startingRow++;

        }

    }
}

