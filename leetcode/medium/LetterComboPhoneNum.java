class Solution {
    public List<String> letterCombinations(String digits) {
        //BFS iterative permutation: O(3^M * 4^M) complexity where M is the number of the digits
        if(digits.isEmpty() || digits == null) return new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        
        String[] values = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        result.offer("");
        for(int i = 0; i<digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i)); //numeric value of the char
            while(result.peek().length() == i){
                String perm = result.poll();
                for(char c: values[index].toCharArray()){
                    result.offer(perm + c);
                }
            }
        }
        return result;
    }
}

// Backtracking
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty() || digits == null) return new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        
        String[] values = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        backtrack(digits, result, "", values);
        return result;
    }
    
    public void backtrack(String digits, LinkedList<String> result, String s, String[] values){
        if(digits.length() == s.length()){
            result.offer(s);
            return;
        }
        
        int index = digits.charAt(s.length()) - '0'; // gets numeric value of digit
        for(char letter: values[index].toCharArray()){
            backtrack(digits, result, s + Character.toString(letter), values);
        }
    }
}
