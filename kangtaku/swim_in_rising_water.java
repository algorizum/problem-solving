class Solution {
    int[][] arrows = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int swimInWater(int[][] grid) {
        int lo = 0, hi = -1;
        int n = grid.length,i,j;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                hi=Math.max(hi,grid[i][j]);
            }
        }
        lo=Math.max(grid[0][0],grid[n-1][n-1]);
        while(lo<hi){
            int mid=(lo+hi)/2;
            int[][] v = new int[n][n];
            if(approach(0,0,grid,v,mid)){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
    
    public boolean approach(int i, int j, int[][] grid,int[][] v,int t) {
        int n=grid.length;
        if(i==-1||j==-1||j==n||i==n||grid[i][j]>t||v[i][j]==1)return false;
        if(i==n-1&&j==n-1)return true;
        v[i][j]=1;
        boolean res=false;
        for(int[] a:arrows){
            res|=approach(i+a[0],j+a[1],grid,v,t);
            if(res)break;
        }
        return res;
    }
}
