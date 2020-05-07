class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Given nums = [2, 7, 11, 15], target = 9,
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            int temp = target-nums[i];
            if(!map.containsKey(temp)){
                map.put(nums[i], i);
            } else{
                return new int[] {map.get(temp), i};
            }
        }
        
        return new int[] {-1};
        
    }
}