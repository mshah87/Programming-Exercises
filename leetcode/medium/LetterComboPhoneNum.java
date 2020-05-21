class Solution {
    public List<String> letterCombinations(String digits) {
        //BFS Permutation: O(3^M * 4^M) complexity where M is the number of the digits
        LinkedList<String> result = new LinkedList<>();
        if(digits.length() == 0){
             return result;
         }

         String[] values = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
         result.add("");
        
        for(int i=0; i<digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i)); //numeric value of the char
            while(result.peek().length() == i){
                String perm = result.remove();
                for(char c: values[index].toCharArray()){
                    result.add(perm + c);
                }
            }
        }
        return result;
    }
}