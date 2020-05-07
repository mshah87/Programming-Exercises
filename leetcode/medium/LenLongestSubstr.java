import java.util.HashSet;

//#3- medium

public class LenLongestSubstr {

    public static int LongestSubstring(String str) {

        int i = 0;
        int j=0;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (i < str.length()) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i++));
                max = Math.max(max, set.size());
            } else {
                set.remove(str.charAt(j++));
            }
        }

        return max;

    }

    public static void main(String args[]) {

        System.out.println(LongestSubstring("pwwkew"));

    }
}
