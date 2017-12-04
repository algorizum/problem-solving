class Solution {
    public int pivotIndex(int[] nums) {
        int i, n = nums.length;
        int[] sums = new int[n + 1];
        for (i= 0; i < n; i++) sums[i + 1] = sums[i] + nums[i];
        for (i = 0; i < n; i++) {
            if (sums[i] - sums[0] == sums[n] - sums[i + 1]) return i;
        }
        return -1;
    }
}
