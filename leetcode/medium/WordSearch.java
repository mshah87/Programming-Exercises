class Solution {
    public boolean exist(char[][] board, String word) {
        //O(N) complexity, where N is number of cell in grid
        // O(N) worst space
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0) ){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int i, int j, int count){
        if(count == word.length()) return true; // if count equals length of word, we found the word
        
        //check bounds and check if current cell is not the character we're looking for 
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j] != word.charAt(count)){
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = '*';
        
        // from current spot can we find remainder of characters
        boolean found = dfs(board, word, i + 1, j, count + 1) ||
            dfs(board, word, i - 1, j, count + 1) ||
            dfs(board, word, i, j + 1, count + 1) ||
            dfs(board, word, i, j - 1, count + 1);
        
        board[i][j] = temp; //restore previous value
        return found;
    }
}