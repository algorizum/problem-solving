class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1, mIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                mIdx = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != mIdx && max < nums[i] * 2) {
                return -1;
            }
        }
        return mIdx;
    }
}
