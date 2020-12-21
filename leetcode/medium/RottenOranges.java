class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rotten = new LinkedList();
        int r = grid.length, c = grid[0].length, fresh = 0, t = 0;
        for(int i = 0; i < r; ++i){
            for(int j = 0; j < c; ++j){
                if(grid[i][j] == 2) rotten.add(new int[]{i, j});
                else if(grid[i][j] == 1) fresh++;
            }
        }
        
        while(!rotten.isEmpty()){
            int num = rotten.size();
            for(int i = 0; i < num; ++i){
                int x = rotten.peek()[0], y = rotten.peek()[1];
                rotten.remove();
                if(x > 0 && grid[x-1][y] == 1){ grid[x-1][y] = 2; fresh--; rotten.add(new int[]{x-1, y});};
                if(y > 0 && grid[x][y-1] == 1){ grid[x][y-1] = 2; fresh--; rotten.add(new int[]{x, y-1});};
                if(x < r-1 && grid[x+1][y] == 1){ grid[x+1][y] = 2; fresh--; rotten.add(new int[]{x+1, y});};
                if(y < c-1 && grid[x][y+1] == 1){ grid[x][y+1] = 2; fresh--; rotten.add(new int[]{x, y+1});};
            }
            if(!rotten.isEmpty()) t++;
        }
        return (fresh == 0) ? t : -1;
    }
}
