class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
          
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
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