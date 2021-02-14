class Solution {
    public int maxAreaOfIsland(int[][] grid) { // O(m*n) complexity
        if(grid == null || grid.length==0){
            return 0;
        }
        int max = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }
    
    public int dfs(int[][]grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] ==0){
            return 0;
        }
        grid[i][j] = 0; //mark as visited
        int area = 1;
        
        area+=dfs(grid, i+1, j); // down
        area+=dfs(grid, i-1, j); //up
        area+=dfs(grid, i, j + 1); // right
        area+=dfs(grid, i, j - 1); // left
        return area;
    }
}
