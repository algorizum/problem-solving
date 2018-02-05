
public class MinCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		if(cost.length<3)return Math.min(cost[0], cost[1]);
		int a=cost[0],b=cost[1];
		int c;
	
		for(int i=2;i<cost.length;i++){
			c=b;
			b=Math.min(a+cost[i], b+cost[i]);
			a=c;
		}
		return Math.min(a, b);
	}
}
