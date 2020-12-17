class Solution {
    public List<String> generateParenthesis(int n) {
        // cannot close until we open, goal is to do n*2 placements
        List<String> result = new ArrayList<>();
        dfs(result, n, n, "");
        return result;
    }
    
    private void dfs(List<String> result, int open, int close, String s){
        if(open==0 && close==0){ // no more parentheses to add
            result.add(s);
            return;
        }
        
        if(open > 0){
            dfs(result, open - 1, close, s + "("); // initially open will be added
        }
        
        if(close > 0 && open<close){ // open has to be < close in order to add a closing brace
            dfs(result, open, close-1, s + ")");
        }
    } 
}
