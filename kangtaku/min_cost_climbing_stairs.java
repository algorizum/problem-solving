class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length, first = cost[0], second = cost[1];
        for (int i = 2; i < n; i++) {
            int t = Math.min(first, second) + cost[i];
            first = second;
            second = t;
        }
        return Math.min(first, second);
    }
}
