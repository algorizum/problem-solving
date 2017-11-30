class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int i, j, n = nums.length, t;
        int[] d = new int[1000001];
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                t = Math.abs(nums[i] - nums[j]);
                d[t]++;
            }
        }
        for (i = 0; i < 1000001; i++) {
            k -= d[i];
            if (k <= 0) return i;
        }
        return 0;
    }
}
