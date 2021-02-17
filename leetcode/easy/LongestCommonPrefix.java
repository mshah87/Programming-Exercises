class Solution {
    public String longestCommonPrefix(String[] strs) { // faster solution O(n) complexity
        if(strs == null || strs.length == 0){
            return "";
        }
        
        String prefix = strs[0]; // compare rest of the strings with first string
        for(int i = 1; i<strs.length; i++){
            while(!strs[i].startsWith(prefix)){ 
                prefix = prefix.substring(0, prefix.length() - 1); // decrement prefix by 1
            }
        }
        return prefix;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // O(n*m): n is number of strings in list, m is max # chars a string contains
        if(strs == null || strs.length == 0){
            return "";
        }
        
        String result = "";
        int index = 0; // char we're comparing currently 
        for(char c: strs[0].toCharArray()){
            for(int i = 1; i<strs.length; i++){
                if(index >= strs[i].length() || c!= strs[i].charAt(index)){ // out of bounds check and if starting chars don't match
                    return result;
                }
            }
            index++; // compare next char
            result+=c;
        }
        return result;
    }
}
