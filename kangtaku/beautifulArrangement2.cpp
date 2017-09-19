class Solution {
public:
    vector<int> constructArray(int n, int k) {
        int left = 1, right = k + 1, count, i;
        vector<int> ans;
        while (left < right) {
            ans.push_back(left++);
            ans.push_back(right--);
        }
        if (left == right) {
            ans.push_back(left);
        }
        for (i = k + 2; i <= n; i++) {
            ans.push_back(i);
        }
        return ans;
    }
};
