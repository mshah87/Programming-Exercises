class Solution {
    public int missingNumber(int[] nums) {
        //O(n) time O(1) space
        //0^a = a
        //a^a = 0
        //thus: indices 0 to n ^ actual nums in array -> gives odd one out
        int xor = 0;
        for(int i = 0; i<nums.length; i++){
            xor = xor ^ nums[i] ^ i + 1;
        }
        return xor;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        //O(n) time O(n) space
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        
        for(int i = 0; i<=nums.length; i++){
            if(!set.contains(i)){
                return i;
            } 
        }
        return -1;
    }
}



class Solution {
    public int missingNumber(int[] nums) {
        //If nums are already sorted O(logn) time O(1) space
        // 0 to n - [0,1,2,3,4,6,7]
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] > mid){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
