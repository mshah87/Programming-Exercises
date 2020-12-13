class Solution {
    public String minWindow(String s, String t) { // O(n) time
        if(s.isEmpty() || t.length() > s.length()) return "";
        
        String res = "";
        int[] hash = new int[128];
        int start = 0, count = 0, minLen = Integer.MAX_VALUE;
        
        for(char c: t.toCharArray()){
            hash[c]++;
        }
        
        for(int end = 0; end<s.length(); end++){
            if(hash[s.charAt(end)] > 0){ // if we found character in t
                count++;
            }
            hash[s.charAt(end)]--; // decrement since we saw it
            
            while(count == t.length()){ // the current window has all the chars from t
                if(minLen > end - start + 1){
                    minLen = end - start + 1; // update min length
                    res = s.substring(start, end + 1); 
                }
                
                //now lets reduce window size
                hash[s.charAt(start)]++; // discard left most char, restore it
                if(hash[s.charAt(start)] > 0){ // it was one of chars in t we needed
                    count--;
                }
                start++;
            }
        }
        return res;
    }
}
