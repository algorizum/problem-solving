class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int n = prices.length, no = 0, have = -prices[0], price;
        for (int i = 1; i < n; i++) {
            price = prices[i];
            no = Math.max(no, have + price - fee);
            have = Math.max(have, no - price);
        }
        return no;
    }
}
