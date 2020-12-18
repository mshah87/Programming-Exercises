class Solution {
    public int findCircleNum(int[][] M) { // O(n^2) time, n is # of students
        int count = 0;
        for(int i = 0; i<M.length; i++){
            if(M[i][i] == 1){
                count++;
                dfs(M, i);
            }
        }
        return count;
    }
    
    private void dfs(int[][] M, int j){
        if(M[j][j] == 0){
            return;
        }
        for(int i = 0; i<M.length; i++){
            if(M[j][i] == 1){
                M[j][i] = 0; // mark as visited
                dfs(M, i);
            }
        }
    }
}
