class Solution {
    public String mostCommonWord(String paragraph, String[] banned) { // O(N) complexity, O(N) space
        String[] words = paragraph.toLowerCase().split("\\W+");
        
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : banned){
            set.add(word);
        }
        
        for(String word: words){
            if(!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        
        int max = 0;
        String result = "";
        for(String word: map.keySet()){
            if(map.get(word) > max){
                max = map.get(word);
                result = word;
            }
        }
        return result;
    }
}