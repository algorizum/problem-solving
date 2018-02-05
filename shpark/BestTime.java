
public class BestTime {
	public int maxProfit(int[] prices, int fee) {
		int have = prices.length > 0 ? -prices[0] : 0, not = 0;

		for (int p : prices) {
			not = Math.max(p + have - fee, not);
			have = Math.max(not - p, have);
		}
		return not;
	}
}
