class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int i,j,k,n=matrix.length,m=matrix[0].length;
        for(i=0;i<n;i++){
            for(k=0;k+i<n;k++){
                if(i+k<n&&k<m){
                if(matrix[i+k][k]!=matrix[i][0]) return false;
                }
            }
        }
        for(j=0;j<m;j++){
            for(k=0;k+j<m;k++){
                if(j+k<m&&k<n){
                if(matrix[k][j+k]!=matrix[0][j]) return false;
                }
            }
        }
        return true;
    }
}
