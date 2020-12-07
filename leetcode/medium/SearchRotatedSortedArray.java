class Solution {
    public int search(int[] nums, int target) { // O(logn) time modified binary search
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return mid;
            
            //left half uniformly increasing
            if(nums[mid] >= nums[lo]){
                if(target>=nums[lo] && target <= nums[mid]){ //is target present in left half
                    hi = mid-1;
                } else {
                    lo = mid + 1;
                }
            } else { // right half uniformly increasing
                if(target>=nums[mid] && target <= nums[hi]){ //is target present in right half
                    lo = mid + 1;
                } else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
