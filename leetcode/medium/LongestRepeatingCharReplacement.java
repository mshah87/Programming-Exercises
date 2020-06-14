class Solution {
    public int characterReplacement(String s, int k) { //Sliding window
        int[] count = new int[26];
        int start = 0; 
        int maxCount = 0;
        int maxLength = 0;
        for(int end = 0; end<s.length(); end++){
            count[s.charAt(end) - 'A']++; //adds freq of each letter. doing - 'A' gives correct index
            maxCount = Math.max(maxCount, count[s.charAt(end) - 'A']); //largest count of char in current window
            
            while(end - start - maxCount + 1 > k){
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}

/*
If we have window with "xxxy" and k = 1, that's fine because end-start+1-maxCount = 1, which is not > k. maxLength gets updated to 4.
But if we then find a "z" after, like "xxxyz", then we need to shrink the window because now end-start+1-maxCount = 2, and 2 > 1. The window becomes "xxyz".
*/