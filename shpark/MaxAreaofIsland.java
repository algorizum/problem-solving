class Solution {
   public int maxAreaOfIsland(int[][] grid) {
		int[][]visited=new int[grid.length][grid[0].length];
		int max=0;
		for(int i=0; i<grid.length;i++){
			for(int j=0; j<grid[0].length;j++){
				if(visited[i][j]==0 && grid[i][j]==1){
					max=Math.max(max, dfs(grid,visited,i,j));
				}
			}
		}
		return max;
	}

	private int dfs(int[][] grid, int[][]visited,int i, int j) {
		if(visited[i][j]==1 || grid[i][j]==0) return 0;
		
		visited[i][j]=1;
		int sum=1;
		if(i>=1) sum+=dfs(grid,visited,i-1,j);
		if(i+1<grid.length)sum+=dfs(grid,visited,i+1,j);
		if(j>=1)sum+=dfs(grid,visited,i,j-1);
		if(j+1<grid[0].length)sum+=dfs(grid,visited,i,j+1);
		return sum;
	}
}