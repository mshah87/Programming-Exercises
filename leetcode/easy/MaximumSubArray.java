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
