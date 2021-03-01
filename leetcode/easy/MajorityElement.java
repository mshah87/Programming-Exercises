class Solution {
    public int majorityElement(int[] nums) {
        // boyer-moore majority vote algorithm: O(N) time, O(1) space
        // idea: vote cancels out each occurrence of an element n if we encouneter a diff element, otherwise add on votes
        // element n will occur till the end if it's the majority element
        int candidate = nums[0];
        int count = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i] == candidate) {
                count++;
            } else {
                count--;
                if(count == 0){
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}

// other methods 
// 1.) sort and find elem that occurs > n/2 times
// 2.) hashmap
