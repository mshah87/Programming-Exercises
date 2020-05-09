class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //O(NlogK) complexity using Hashmap and minHeap
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        //lambda function: sorts the keys alphabetical when they have same frequency (value)
        //compareTo() method is used for comparing two strings lexicographically. Each character 
        //of both the strings is converted into a Unicode value for comparison. 
        //If both the strings are equal then this method returns 0 else it returns positive 
        //or negative value. The result is positive if the first string is lexicographically greater 
        //than the second string else the result would be negative.
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> (map.get(a) == map.get(b) ? b.compareTo(a): map.get(a) - map.get(b)));
        
        for(String word: map.keySet()){
            minHeap.offer(word);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        List<String> list = new ArrayList<>();
        while(!minHeap.isEmpty()){
            list.add(0, minHeap.poll());
        }
        return list; 
    }
}

//Second method: hashmap + bucketsort + trie, O(N) complexity
//store words and its freq in hashmap 
//use bucketsort to store words
//define trie within each bucket to store all the words with the same frequency. 
//With Trie, it ensures lexicographic order of words