package leetcode.easy;

import java.util.Arrays;

class Solution {
  int[] cost;
  int[] cache;
  public int minCostClimbingStairs(int[] cost) {
    this.cost = cost;
    this.cache = new int[cost.length];
    Arrays.fill(cache, -1);
    return Math.min(minDP(0), minDP(1));
  }
  private int minDP(int i) {
    if (i >= cost.length) return 0;
    if (cache[i] != -1) return cache[i];
    cache[i] = cost[i] + Math.min(minDP(i+1), minDP(i+2));
    return cache[i];
  }
}
