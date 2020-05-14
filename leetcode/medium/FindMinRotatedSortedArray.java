class Solution {
    public int findMin(int[] nums) {
        //Binary search: O(logN) complexity
        //The interval low to high will always change, in the end we return the low
        int low = 0, high = nums.length-1;
        while(low<high){
            int mid = low + (high-low) / 2; //avoid overflow
            if(nums[mid] < nums[high]){ //min is in left part
                high = mid;
            } else if(nums[mid] > nums[high]){ //min is in right part
                low = mid + 1;
            }
        }
        return nums[low];
    }
}