class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //using hashmap and bucket sort method: O(N)
        //build freq map 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        //bucket sort on map
        List<Integer> [] bucket = new List[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>(); //only add arraylist in the bucket's index if there exists a frequency
            }
            bucket[freq].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length-1; i>=0 && result.size() < k; i--){
            if(bucket[i] != null){
                result.addAll(bucket[i]);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //using hashmap and priority queue (minheap) method: 0(NlogK)

        //Minheap: O(NlogK) because we don't need to insert in heap N times, only K times.
        //insertion/deletion takes logK times for N elements.
        //compare the rest of the elements with the root, substituting with the root only elements which are greater than the root, 
        //so the Min Heap has always k greatest elements.

        //Maxheap: O(NlogN) because insert all elements(N) in heap and pick
        //top k elements (max elements at top)

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        //sort based on value in map which is frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(num -> map.get(num)));

        for(int num: map.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){ //minheap will have at most k elements
                minHeap.poll();
            }
        }
        return minHeap.stream().mapToInt(Integer::intValue).toArray();
    }
}
