class Solution {
    public int maxSubArray(int[] nums) {
        //O(n) complexity
        int maxSum = Integer.MIN_VALUE;
        int sumSoFar = 0;
        for(int i = 0; i<nums.length; i++){
            sumSoFar += nums[i];
            if(sumSoFar>maxSum){
                maxSum = sumSoFar;
            } 
            if(sumSoFar < 0){
                sumSoFar = 0;
            }
        }
        return maxSum;
    }
}

//simplifying the code by using math.max()
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sumSoFar = 0;
        for(int i = 0; i<nums.length; i++){
            sumSoFar += nums[i];
            maxSum = Math.max(sumSoFar, maxSum);
            sumSoFar = Math.max(sumSoFar, 0);
        }
        return maxSum;
    }
}