class Solution {
    public boolean isPalindrome(String s) {
        int l = 0; 
        int r = s.length()-1;
        while(l<=r){
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(!Character.isLetterOrDigit(lc)){ //if its not a letter or digit, ignore
                l++;
            } else if(!Character.isLetterOrDigit(rc)){ //if its not a letter or digit, ignore
                r--;
            } else { //it is a letter or digit 
                if(Character.toLowerCase(lc) != Character.toLowerCase(rc)){ //if lc doesn't equal rc
                    return false;
                }
                //if lc does equal rc, just continue 
                 l++; 
                 r--;
            }
        }
        return true;
    }
}