class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] nums = String.valueOf(N).toCharArray();
        int n = nums.length, idx = n, i;
        for (i = n - 1; i >= 1; i--) {
            int num = nums[i] - '0';
            int prevNum = nums[i - 1] - '0';
            if (prevNum > num) {
                nums[i - 1] = (char)((prevNum - 1) + '0');
                idx = i;
            }
        }
        for (i = idx; i < n; i++) {
            nums[i] = '9';
        }
        return Integer.valueOf(String.valueOf(nums));
    }
}
