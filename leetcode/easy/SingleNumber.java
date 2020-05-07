class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            } else {
                map.put(i, map.get(i)+1);

            }
        }
        
        for ( Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            if (map.get(k) == 1) {
                return k;
            }
        }
        return -1;
    }
}