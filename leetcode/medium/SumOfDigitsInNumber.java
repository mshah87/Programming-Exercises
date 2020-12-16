class Solution { 
    public int digitSum(int n){ // until sum becomes single digit
        // O(1) time
        // 1918 -> 199-> 118 -> 19 -> 10 -> 1
        int sum = 0;
        while (n>0 || sum > 9) {
            if(n == 0){
                n = sum;
                sum = 0;
            }
            sum+= n % 10;
            n = n / 10;
        } 
        return n;
    } 
}
