class Solution { //O(N) complexity
    public int maxProduct(int[] nums) {
        int finalMax = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i]<0){
                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            
            currMax = Math.max(nums[i], nums[i] * currMax);
            currMin = Math.min(nums[i], nums[i] * currMin);
            finalMax = Math.max(finalMax, currMax);
        }
        return finalMax;
    }
}