class Solution {
    public int lengthOfLongestSubstring(String s) {
        // O(n) complexity: sliding window
        int i = 0;
        int j=0;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
                i++;
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }
        return max;
    }
}