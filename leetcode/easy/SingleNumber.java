class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
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

class Solution {
    public int singleNumber(int[] nums) { //No extra memory. Bit manipulation XOR
        // Ex: If {2,1,4,5,2,4,1}
        // ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5 
        // Picking odd one out
        int result = 0;
        for (int i = 0; i<n; i++){
            result ^=A[i];
        }
        return result;
    }
}