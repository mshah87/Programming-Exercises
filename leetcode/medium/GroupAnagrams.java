class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Sorting: O(nmlog(m)) complexity, n is # of words and m is length of words
        if(strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch); // keys in hashmap are sorted
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            } 
            map.get(key).add(s); // add the unsorted string as value
        }
        return new ArrayList<>(map.values());
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Without sorting: O(m*n) complexity
        if(strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] bucket = new char[26]; //count frequency of s instead of sorting
            for(char ch: s.toCharArray()){
                bucket[ch - 'a']++;
            }
            String key = new String(bucket); 
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}