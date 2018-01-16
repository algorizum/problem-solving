class Solution {
public:
  int deleteAndEarn(vector<int> nums) {
    vector<int> sum(10001);
    vector<vector<int>> dp(10001, vector<int>(2, -1));
    for (auto num : nums) {
      sum[num] += num;
    }
    return go(sum, dp, 1, 1);
  }
private:
  int go(vector<int>& sum, vector<vector<int>>& dp, int idx, int can) {
    if (idx > 10000) return 0;
    int& ret = dp[idx][can];
    if (ret != -1) return ret;

    ret = go(sum, dp, idx + 1, 1);
    if (can) ret = max(ret, go(sum, dp, idx + 1, 0) + sum[idx]);

    return ret;
  }
};
