class Solution {
    public void moveZeroes(int[] nums) { //Input: [1,0,3,0,12], in place O(N) complexity
        if(nums == null) return;
        int anchor = 0;
        for(int explore = 0; explore<nums.length; explore++){
            if(nums[explore] != 0){ // move until find nonzero
                int temp = nums[anchor]; // swap with anchor (which is on a zero)
                nums[anchor] = nums[explore];
                nums[explore] = temp;
                anchor++;
            }
        }
    }
}