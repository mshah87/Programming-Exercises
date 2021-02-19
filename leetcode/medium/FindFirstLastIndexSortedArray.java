class Solution {
    public int[] searchRange(int[] nums, int target) { // O(logn) complexity, two binary searches
        int[] result = new int[2];
        result[0] = findStartPosition(nums, target);
        result[1] = findEndPosition(nums, target);
        
        return result;
    }
    
    public int findStartPosition(int[] nums, int target){
        int index = -1; // if cannot find target
        int start = 0;
        int end = nums.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target<=nums[mid]){ // look on left side, or we found target but we still want to move to the left (if there are duplicates we want first occurrence of it so we keep moving left)
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if(target == nums[mid]){ // found index, update it 
                index = mid;
            }
        }
        return index;
    }
    
    public int findEndPosition(int[] nums, int target){
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target>=nums[mid]){ // look on right side, or we found target but we still want to move to the right (if there are duplicates we want last occurrence of it so we keep moving right)
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if(target == nums[mid]){ // found index, update it 
                index= mid;
            }
        }
        return index;   
    }
}
