class Solution {
public:
    int maximumSwap(int num) {
        string numStr = to_string(num);
        int n = numStr.size();
        int ans = num;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(numStr[i], numStr[j]);
                ans = max(ans, stoi(numStr));
                swap(numStr[i], numStr[j]);
            }
        }
        return ans;
    }
};
