class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char r: s.toCharArray()){
            if(map.get(r)==1){
                return s.indexOf(r);
            }
        }
        return -1;
    }
}