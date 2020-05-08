class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //using hashmap and bucket sort method
        //build freq map 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        //bucket sort on map
        List<Integer> [] bucket = new List[nums.length+1];
        for (int i = 0; i < bucket.length; i++) bucket[i] = new ArrayList();
        for(int key: map.keySet()){
            bucket[map.get(key)].add(key);
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=bucket.length - 1; i>=0; i--){
            if(bucket[i] != null){
                list.addAll(bucket[i]);
                if(list.size() >= k) break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}