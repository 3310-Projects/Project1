import java.lang.*;
class Matrix {
    public int size = 4;
    
    public static void main(String[] args) {
        Matrix m = new Matrix();
        
        int size = 512;                                 ////////////////CHANGE SIZE
        int outputSize = size;                   
    
        
        int [][] A = m.generateArray(size);   
        int [][] B = m.generateArray(size);      
        int startTime, endTime, runTime;
        int [][] output = new int[outputSize][outputSize];
        ///////////////////////////////////////STRASSEN ////////////////////////////
        startTime = (int) System.currentTimeMillis();
        System.out.println("Strassen Multiplication: ");
        output = m.strassenMult(A, B, size);  
        endTime = (int) System.currentTimeMillis();
        runTime = endTime - startTime;
        System.out.println("Runtime: " + runTime + " milliseconds");

        ///////////////////////////////////////////NAIVE///////////////////////////////////
        startTime = (int) System.currentTimeMillis();
        System.out.println("Naive Multiplication: ");
        output = m.classicMult(A, B);
        endTime = (int) System.currentTimeMillis();
        runTime = endTime - startTime;
        System.out.println("Runtime: " + runTime + " milliseconds");

    }
    
    
    
    public int[][] strassenMult(int[][]A, int[][]B, int size){
        int[][] output = new int[size][size];
        if(size == 1){
            output[0][0] = A[0][0] * B[0][0];
        }else{
            int newSize = size/2;
            
            int[][] a = new int[newSize][newSize];
            int[][] b = new int[newSize][newSize];
            int[][] c = new int[newSize][newSize];
            int[][] d = new int[newSize][newSize];
            int[][] e = new int[newSize][newSize];
            int[][] f = new int[newSize][newSize];
            int[][] g = new int[newSize][newSize];
            int[][] h = new int[newSize][newSize];
  

            split(A, a, 0, 0);
            split(B, e, 0, 0);
            split(A, b, 0, newSize);
            split(B, f, 0, newSize);
            split(A, c, newSize, 0);
            split(B, g, newSize, 0);
            split(A, d, newSize, newSize);
            split(B, h, newSize, newSize);
           
            int[][] p1 = classicMult(a, subtract(f, h));
            int[][] p2 = classicMult(add(a, b), h);
            int[][] p3 = classicMult(add(c, d), e);
            int[][] p4 = classicMult(d, subtract(g, e));
            int[][] p5 = classicMult(add(a, d), add(e, h));
            int[][] p6 = classicMult(subtract(b, d), add(g, h));
            int[][] p7 = classicMult(subtract(a, c), add(e, f));
            int[][] outputa = add(p5, subtract(p4, add(p2, p6)));
            int[][] outputb = add(p1, p2);
            int[][] outputc = add(p3, p4);
            int[][] outputd = subtract(add(p1, p5), subtract(p3, p7));

            merge(outputa, output, 0, 0);
            merge(outputb, output, 0, newSize);
            merge(outputc, output, newSize, 0);
            merge(outputd, output, newSize, newSize);
            
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
    public void print(int [][] output){
        size = output.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] generateArray(int size){
        int [][] arrayToGenerate = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arrayToGenerate[i][j] = (int)(Math.random() * 10);
            }
        }
        return arrayToGenerate;
    }
}

