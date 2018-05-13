class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 1, now = 1;
        while (sum(now) < N) {
            if ((N - sum(now)) % (now + 1) == 0) ans++;
            now++;
        }
        return ans;
    }
    
    public int sum(int to) {
        return (to * (to + 1)) / 2;
    }
}
