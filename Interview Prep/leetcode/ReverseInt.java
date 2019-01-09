class Solution {

    public int reverse(int x) {
        int revNum = 0;
        while (x != 0) {
            revNum = revNum * 10 + x % 10;
            x = x / 10;
        }
        return revNum;

    }

}