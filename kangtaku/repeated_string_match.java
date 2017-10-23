class Solution {
    final static int MOD1 = 1000000007, MOD2 = 1000000009;
    final static long PRIME = 31;
    
    public int repeatedStringMatch(String A, String B) {
        int aHash = 0, bHash = 0, mPrime = 1;
        int i, n = A.length(), m = B.length();
        int max = 1;
        
        while (n * max < m) {
            max++;
        }

        for (i = 0; i < m; i++) {
            aHash = (int) (((PRIME * aHash) + A.charAt(i % n)) % MOD1);
            bHash = (int) (((PRIME * bHash) + B.charAt(i)) % MOD1);
            mPrime = (int) ((mPrime * PRIME) % MOD1);
        }

        if (aHash == bHash) {
            return max;
        }
        int start = m;
        for (i = m; i < (max + 1) * n; i++) {
            aHash = (int) ((PRIME * aHash + A.charAt(i % n) - 1L * A.charAt((i - m) % n) * mPrime % MOD1 + MOD1) % MOD1);
            if (aHash == bHash) {
                return i < max * A.length() ? max : max + 1;
            }
        }
        return -1;
    }
}
