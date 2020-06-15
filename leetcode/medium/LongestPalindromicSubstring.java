class Solution {
    public String longestPalindrome(String s) { // O(N^2) complexity
        if(s == null || s.length() < 1) return "";
        
        int start = 0;
        int end = 0;
        for(int i = 0; i<s.length(); i++){
            int oddLen = expandFromMiddle(s, i, i);
            int evenLen = expandFromMiddle(s, i, i+1);
            int maxLen = Math.max(oddLen, evenLen);
            if(maxLen > end - start){ // we found a longer substring 
                start = i - ((maxLen - 1)/2); // left boundary
                end = i + ((maxLen)/2); // right boundary
            }
        }
        return s.substring(start, end + 1); //start and end indices of the longest palindromic substring
    }
    
    public int expandFromMiddle(String s, int l, int r){
        while(l>=0 && r<=s.length() - 1 && s.charAt(l) == s.charAt(r)){
            l--; // trace string in left direction
            r++; // trace string in right direction
        }
        return r - l - 1;
    }
}

//brute force: N^3 - nested loop for string permutations with helper function to check palindrome