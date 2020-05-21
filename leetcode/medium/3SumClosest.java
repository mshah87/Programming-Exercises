/*
Given array nums = [-1, 2, 1, -4], and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3 || nums == null){
            return -1;
        }

        Arrays.sort(nums); //sort least to greatest
        int closestSum = nums[0] + nums[1] + nums [2];

        for(int i = 0 ; i < nums.length; i++){
            int start = i+1; 
            int end = nums.length - 1;
            while(start<end){
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(target-sum) < Math.abs(target-closestSum)){ //find the minimum difference 
                    closestSum = sum;
                } 
                if(sum<target){ //if sum is lower than target, move start pointer up 
                    start++;
                } else {
                    end--; //if sum is bigger than target, move end pointer down
                }
            }
        }
        return closestSum;
    }
}