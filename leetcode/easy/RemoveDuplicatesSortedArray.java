class Solution {
    public int removeDuplicates(int[] nums) {
        //[1,2,3,3] -> length = 3
        if(nums.length == 0) return 0;
        int i = 0; // slow pointer
        for(int j = 1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++; // doesn't update current element, always the next
                nums[i] = nums[j];
            }
        }
        return i + 1; // has all unique elements
    }
}
