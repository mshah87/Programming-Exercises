class Solution {
    public int countPrimes(int n) { // O(Nlog(log N)) complexity, O(N) space
        if(n<2) return 0;
        int count = 0;
        boolean[] notPrime = new boolean[n]; // default is false
        for(int i = 2; i<n; i++){
            if(notPrime[i] == false){ // it is prime so increment count
                count++;
                for(int j = i; j<n; j+=i){ 
                    notPrime[j] = true; // multiples of i cannot be prime so notPrime = true
                }
            }
        }
        return count;
    }
}
