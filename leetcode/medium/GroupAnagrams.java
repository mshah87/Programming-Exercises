class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //O(NKlog(K)) complexity, N is # of words and K is length of words
        if(strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            } 
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}