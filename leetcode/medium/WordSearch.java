class Solution {
    public boolean exist(char[][] board, String word) {
        //O(N) complexity, where N is number of cell in grid
        // O(N) worst space
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, int count, String word){
        if(count == word.length()){ //if count equals length of word, we found the word
            return true;
        }
        
        if(i<0 || i> board.length - 1 || j < 0 || j> board[0].length - 1 || board[i][j] != word.charAt(count)){ //check if dfs goes over bounds
            return false;
        }
        
        char temp = board[i][j];
        board[i][j] = '*';  //mark current cell as used
        boolean found = dfs(board, i + 1, j, count + 1, word) 
            || dfs(board, i - 1, j, count + 1, word) 
            || dfs(board, i, j + 1, count + 1, word) 
            || dfs(board, i, j - 1, count + 1, word); 
        
        board[i][j] = temp; //add value back
        return found;
    }
}

/*
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/