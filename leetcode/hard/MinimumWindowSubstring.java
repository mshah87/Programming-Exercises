class Solution {
    public String minWindow(String s, String t) { // Sliding Window: O(N) complexity O(N) space
        if(s.isEmpty() || t.length() > s.length()) return "";

        int[] hash = new int[128];
        int start = 0, minStart = 0, end = 0, minLen = Integer.MAX_VALUE, count = t.length();
        
        for(char c: t.toCharArray()){
            hash[c]++;
        }
        
        while(end < s.length()){
            char ch = s.charAt(end);
            if(hash[ch] > 0){ // if current character is present in t 
                count--;
            }
            hash[ch]--;
            end++;
            while(count == 0){
                if(end - start < minLen){
                    minLen = end - start;
                    minStart = start;
                }
                char ch2 = s.charAt(start);
                hash[ch2]++; /// restore the character count in map
                if(hash[ch2] > 0){
                    count++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}