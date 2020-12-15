class Solution {
    public int coinChange(int[] coins, int amount) { 
        // O(n*m) time, n is amount, m is number of coins
        // O(n) space
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 0; i<=amount; i++){ // dp[i] is amount + 1 initially 
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    //look up best way to make i - coins[j] in dp array
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]); // +1 because we're using the coin
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
