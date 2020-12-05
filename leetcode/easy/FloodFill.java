class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) return image; //if starting pixel already new color, nothing to change
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int currColor, int newColor){
        //check boundaries and if pixel we travelled to from starting pixel is different, no change
        if(i<0 || i>= image.length || j<0 || j>= image[i].length || image[i][j] != currColor){
            return; // no change
        }
        
        //need to change
        image[i][j] = newColor;
        
        dfs(image, i+1, j, currColor, newColor);
        dfs(image, i-1, j, currColor, newColor);
        dfs(image, i, j+1, currColor, newColor);
        dfs(image, i, j-1, currColor, newColor);
    }
}
