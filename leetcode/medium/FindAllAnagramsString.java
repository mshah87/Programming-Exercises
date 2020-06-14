class Solution {
    public List<Integer> findAnagrams(String s, String p) { //Sliding window
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        
        int[] hash = new int[26]; //keep track of characters
        
        for(char c: p.toCharArray()){
            hash[c - 'a']++;
        }
        
        int start = 0;
        int end = 0;
        while(end < s.length()){
            if(hash[s.charAt(end) - 'a'] > 0){
                hash[s.charAt(end) - 'a']--; 
                end++; //expand window
            } else {
                hash[s.charAt(start) - 'a']++; // resets the hash
                start++; //shrink window from left
            }
            
            if(end - start == p.length()){
                res.add(start);
            }
            
        }
        return res;
    }
}