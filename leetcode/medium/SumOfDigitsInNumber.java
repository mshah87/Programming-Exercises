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
            sum+= n % 10; // find last digit and add to sum
            n = n / 10; // remove last digit
        } 
        return n;
    } 
}


class Solution { 
    public int digitSum(int n){ // until sum becomes single digit
        // more efficient O(1) time
        // 1918 -> 199-> 118 -> 19 -> 10 -> 1
        if(n == 0) return 0;
        else if(n % 9 == 0) 
          return 9;
        else
          return n%9;
    } 
}
