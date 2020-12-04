class Solution {
    public int numIslands(char[][] grid) { // DFS: O(m*n), every node touched once
        if(grid == null || grid.length == 0) return 0;
        
        int numIslands = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j =0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    numIslands += dfs(grid, i, j); // after recursive calls run, returns 1 
                }
            }
        }
        return numIslands;
    }
    
    public int dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0'){
            return 0; // no longer want to traverse, not interested
        }
        grid[i][j] = '0'; // mark as visit by assigning 0
        dfs(grid, i+1, j); // down
        dfs(grid, i-1, j); //up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
        return 1; // account for original island we're discovering in the call 
    }
}
