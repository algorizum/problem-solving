class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, lo = 0, hi = nums[n - 1];
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (count(nums, k, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public int count(int[] nums, int k, int v) {
        int n = nums.length, i, j, res = 0;
        j = 0;
        for (i = 0; i < n; i ++) {
            while (v < nums[i] - nums[j]) j++;
            res += i - j;
        }
        return res;
    }
}
