class Solution {
    public int reachNumber(int target) {
        int sum = 0, i;
        if (target < 0) target *= -1;
        for (i = 1;; i++) {
            if (sum + i == target) return i;
            if (sum > target) {
                if ((target - sum) % 2 == 0) return i - 1;
            }
            sum += i;
        }
    }
}
