class Solution {
    public int trap(int[] height) { //O(n) time, O(1) space
        int low = 0;
        int high = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int max = 0;
        while(low<=high){
            leftMax = Math.max(leftMax, height[low]);
            rightMax = Math.max(rightMax, height[high]);
            if(leftMax < rightMax){  //how much can current position trap depends on the shorter wall
                max += leftMax - height[low]; // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                low++; // move lower wall because taller wall may leak water
            } else {
                max += rightMax - height[high];
                high--;
            }
        }
        return max; 
    }
}
