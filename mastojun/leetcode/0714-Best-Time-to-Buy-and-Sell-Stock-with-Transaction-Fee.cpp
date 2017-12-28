class Solution {
public:
    int maxProfit(vector<int>& prices, int fee) {
        int result= 0;
        int m = INT_MAX;
        for (auto price : prices) {
            if (m > price + fee) {
                m = price + fee;
            } else if (m < price) {
                result += price - m;
                m = price;
            }
        }
        return result;
    }
};
