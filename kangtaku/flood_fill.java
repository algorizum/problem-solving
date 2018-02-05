class Solution {
    int n, m;
    int[][] arrow = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][] v;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        n = image.length;
        if (n == 0) return image;
        m = image[0].length;
        v = new int[n][m];
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public void fill(int[][] image, int x, int y, int newColor, int startColor) {
        if (x == -1 || y == -1 || x == n || y == m || image[x][y] != startColor || v[x][y] == 1) return;
        image[x][y] = newColor;
        v[x][y] =1;
        for (int[] arr : arrow) {
            fill(image,x+arr[0],y+arr[1],newColor,startColor);
        }
    }
}
