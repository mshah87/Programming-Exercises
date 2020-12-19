class Solution {
    public int maxSubArray(int[] nums) { // O(n) time
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            if(sum > max){
                max = sum;
            } 
            if(sum<0) {
                sum = 0;
            }
        }
        return max;
    }
}

// dynamic programming O(n) time
class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int max= nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(nums[i], dp[i-1]+ nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

/*
Divide and Conquer O(nlogn) time 

Step1. Select the middle element of the array.
So the maximum subarray may contain that middle element or not.

Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same 
algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.

Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply 
the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray

Step 3 return the maximum of those three answer.
*/
