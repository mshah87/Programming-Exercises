//#128 - hard

class Solution {
    public int longestConsecutive(int[] nums) {
        // if length 0, then there are no consecutive numbers
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        int max = 1;

        // add all numbers in array to the set
        for (int i : nums) {
            set.add(i);
        }

        // variables for left of number and right of number
        for (int i : nums) {
            int count = 1;
            int l = i - 1;
            int r = i + 1;

            while (set.contains(l)) {
                count++;
                set.remove(l);
                l--;
            }

            while (set.contains(r)) {
                count++;
                set.remove(r);
                r++;
            }
            max = Math.max(max, count);

        }

        return max;
    }
}