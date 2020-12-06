class Solution {
    public int[] twoSum(int[] numbers, int target) { // binary search
        int lo = 0;
        int hi = numbers.length - 1;
        while(lo<hi){
            int sum = numbers[lo] + numbers[hi];
            if(sum == target) return new int[]{lo+1, hi+1};
            if(sum >target) {
                hi--;
            } else {
                lo++;
            }
        }
        return new int[]{-1};
    }
}
