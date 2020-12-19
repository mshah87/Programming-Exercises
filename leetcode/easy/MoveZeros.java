class Solution {
    public void moveZeroes(int[] nums) { //Input: [1,0,3,0,12], in place O(N) complexity
        if(nums == null || nums.length == 0) return;

        int curr = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){ 
                int temp = nums[curr]; 
                nums[curr] = nums[i]; // put nonzero elements at front
                nums[i] = temp;
                curr++;
            }
        }
    }
}
