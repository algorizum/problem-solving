
public class Search2DMatrixII {
	/*public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length-1;
		if(m<0)return false;
		int n=matrix[m].length-1;
		if(n<0 || matrix[m][n]<target ||matrix[0][0]>target)return false;

		return func(matrix,0,m,0,n,target);
	}
	private boolean func(int[][] matrix, int m1,int m2, int n1,int n2,int target) {
		if(m1<0||m2>matrix.length||m1>m2||n1<0||n2>matrix[m1].length||n1>n2)return false;
		if(m1==m2 && n1==n2)return matrix[m1][n1]==target;

		boolean res=false;
		int m=(m2-m1)/2+m1,n=(n2-n1)/2+n1;
		if(target==matrix[m][n])
			return true;
		else if(target<matrix[m][n]) 
			res=res |func(matrix,m1,m,n1,n,target);
		else 
			res=res |func(matrix,m+1,m2,n+1,n2,target);
		
		return res?res:func(matrix,m1,m,n+1,n2,target) |func(matrix,m+1,m2,n1,n,target);
	}*/
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length-1;
		if(m<0)return false;
		int n=matrix[m].length-1;
		if(n<0)return false;
		
		int row=m,col=0;
		while(row>=0 && col<=n) {
			int val=matrix[row][col];
			if(val==target)return true;
			else if(val>target)row--;
			else col++;
		}
		return false;
	}
}
