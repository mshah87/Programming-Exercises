/*
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(set);
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length-2; i++){
            int j= i+1;
            int k= nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0){
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                } else if(sum>0){
                    k--;
                } else if(sum<0){
                    j++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}