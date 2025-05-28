class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1_000_000_007;
        long res = 1;
        long a = 5, b = (n + 1) / 2;  

        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }

        a = 4; b = n / 2;  
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }

        return (int) res;
    }
}