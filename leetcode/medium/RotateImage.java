class Solution { //In place: O(N) complexity
     public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i<N; i++){
            for(int j = 0; j<(N/2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = temp;
            }
        }
    }
}

/*
//transpose matrix over diagonal
1  2  3             
4  5  6
7  8  9

//after transpose
1  4  7
2  5  8
3  6  9

//flip matrix horizontally
7  4  1
8  5  2
9  6  3
*/