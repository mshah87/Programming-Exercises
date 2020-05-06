//#11- medium

class Solution {
    public int maxArea(int[] height) {

        int low = 0;
        int high = height.length - 1;
        int maxArea = 0;

        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;

    }
}