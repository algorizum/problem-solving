class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int i,j,k,ans=0;
        int[][] grid=new int[N][N];
        for(i=0;i<N;i++){
            Arrays.fill(grid[i],1);
        }
        for(int[] mine:mines){
            grid[mine[0]][mine[1]]=0;
        }
        for(i=0;i<N;i++){
            for(j=0;j<N;j++){
                if(grid[i][j]==1){
                    for(k=1;;k++){
                        if(i+k<N&&i-k>=0&&j+k<N&&j-k>=0&&grid[i+k][j]==1&&grid[i-k][j]==1&&grid[i][j+k]==1&&grid[i][j-k]==1){
                            continue;
                        }else break;
                    }
                    ans=Math.max(ans,k);
                }
            }
        }
        return ans;
    }
}
