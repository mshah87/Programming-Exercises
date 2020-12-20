class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.isEmpty() && t.isEmpty()) return true;
        
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
    
        // in the end count should have all indices that are 0 because its anagram
        for(int x : count) {
            if(x != 0) return false;
        }
        return true;
    }
}

// hashmap solution, good for unicode characters
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.isEmpty() && t.isEmpty()) return true;
    
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char r: t.toCharArray()){
            if(!map.containsKey(r)){
                return false;
            } else {
                if(map.get(r) > 1){
                    map.put(r, map.get(r)-1);
                } else {
                    map.remove(r);
                }
            }
        }
        return true;
    }
}
