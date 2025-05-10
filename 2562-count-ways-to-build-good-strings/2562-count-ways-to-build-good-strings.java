class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for(int length = 1; length <= high; length++) {
            if(length >= zero) {
                dp[length] = (dp[length] + dp[length - zero]) % mod;
            }
            if(length >= one) {
                dp[length] = (dp[length] + dp[length - one]) % mod;
            }
        }

        int result = 0;
        for(int i = low; i <= high; i++) {
            result = (result + dp[i]) % mod;
        }

        return result;
    }
}