class Solution {
    public void sortColors(int[] nums) { // O(n) time, 1 pass
        int start = 0; 
        int end = nums.length - 1;
        int index = 0;
        while(index<=end){
            if(nums[index] == 0){
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
            } 
            if (nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
                index--;
            } 
            index++;
        }
    }
}
