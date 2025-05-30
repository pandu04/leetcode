class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long absN = Math.abs((long) n);
        double result = power(x, absN);
        if (n < 0) result = 1 / result;
        return result;
    }

    private double power(double x, long n) {
        if (n == 0) return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}