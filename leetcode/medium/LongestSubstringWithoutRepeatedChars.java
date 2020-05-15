class Solution {
    public int lengthOfLongestSubstring(String s) {
        //O(n) complexity
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }
}