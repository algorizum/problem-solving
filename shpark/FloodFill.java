class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		int[][]visited=new int[image.length][image[0].length];
		helper(image,visited,sr,sc,image[sr][sc],newColor);
		return image;
	}
	
	public void helper(int[][] image,int[][]visited,int x,int y,int originColor,int newColor){
		if(visited[x][y]==1)return;
		visited[x][y]=1;
		
		if(x>=1 && originColor==image[x-1][y]) helper(image,visited,x-1,y,originColor,newColor);
		if(image.length>x+1 && originColor==image[x+1][y]) helper(image,visited,x+1,y,originColor,newColor);
		if(y>=1 && originColor==image[x][y-1]) helper(image,visited,x,y-1,originColor,newColor);
		if(image[0].length>y+1 && originColor==image[x][y+1]) helper(image,visited,x,y+1,originColor,newColor);
		
		image[x][y]=newColor;
		
	}
}