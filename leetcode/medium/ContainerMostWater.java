class Solution {
    public int maxArea(int[] height) {
        //O(n) complexity
        int low = 0;   
        int high = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        
        while(low<high){
            int min = Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, min*(high-low));
            if(height[low] < height[high]){ //move low pointer to find a greater value
                low++;
            }else { //move high pointer to find a higher value
                high--;
            }
        }
        return maxArea;
    }
}