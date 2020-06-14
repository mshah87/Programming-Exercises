class Solution { 
    private int count = 1;
    public int countSubstrings(String s) { //O(N) complexity
        if(s == null || s.length() == 0) return 0;
        
        for(int i = 0 ; i<s.length() - 1; i++){ //middle
            countPalindrome(s, i, i); // count odd length palindromic sub-string 
            countPalindrome(s, i, i+1); // count even length palindromic sub-string
        }
        return count;
    }
    
    public void countPalindrome(String s, int i, int j){
        while(i>=0 && j<=s.length() - 1 && s.charAt(i) == s.charAt(j)){
            i--; // trace string in left direction
            j++; // trace string in right direction
            count++;
        }
    }
}