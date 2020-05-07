class Solution {
    public int removeDuplicates(int[] nums) {
        //[1,2,3,3] -> 3
        
        if(nums.length<2){
            return nums.length;
        }
        int i = 0;
        int j = 1;
        while(j<nums.length){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
