class Solution {
    public void rotate(int[] nums, int k) { // O(N) complexity
        if(nums == null || nums.length < 2) return;
        
        k = k % nums.length; // handling when k is bigger than nums.length
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length-1);
    }
    
    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

/*
nums = [1,2,3,4,5,6,7] and k = 3
1.) first we reverse [1,2,3,4], it becomes [4,3,2,1]
2.) then we reverse[5,6,7], it becomes[7,6,5]
3.) finally we reverse the array as a whole, it becomes [4,3,2,1,7,6,5] ---> [5,6,7,1,2,3,4]
*/