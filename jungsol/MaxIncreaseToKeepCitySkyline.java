
public class MaxIncreaseToKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int maxIncreaseValue = 0;
		int[] maxRowHeight = new int[grid.length];
		int[] maxColumnHeight = new int[grid.length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				maxRowHeight[j] = Math.max(grid[i][j], maxRowHeight[j]);
				maxColumnHeight[i] = Math.max(grid[i][j], maxColumnHeight[i]);
			}
		}
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				maxIncreaseValue += (Math.min(maxRowHeight[j], maxColumnHeight[i]) - grid[i][j]);
			}
		}
		return maxIncreaseValue;
	}
	public static void main(String[] args) {
		MaxIncreaseToKeepCitySkyline solution = new MaxIncreaseToKeepCitySkyline();
		int grid[][] = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		System.out.println(solution.maxIncreaseKeepingSkyline(grid)); //35
	}
}
