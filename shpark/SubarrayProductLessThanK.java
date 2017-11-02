class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
		int product = 1;
		int step = 0;
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < k) {
				product *= nums[i];
				step++;
				if (product >= k) {
					while (product >= k) {
						product /= nums[idx];
						idx++;
						step--;
					}
				}
				cnt += step;
			} else {
				product = 1;
				idx = i + 1;
				step = 0;
			}
		}

		return cnt;
	}
}