class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //O(NlogK) complexity using Hashmap and minHeap
        HashMap<String, Integer> map = new HashMap<>();
        for(String str: words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        
        //lambda function: sorts the keys alphabetical when they have same frequency (value)
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