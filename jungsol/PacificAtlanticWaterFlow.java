import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //위,아래,왼쪽,오른쪽
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<>();
        boolean pacific[][] = new boolean[matrix.length][matrix[0].length];
        boolean atlantic[][] = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, matrix[0].length-1);
        }
        for(int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, matrix.length-1, i);
        }
        List<int[]> canFlowToBoth = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(pacific[i][j] && atlantic[i][j]) canFlowToBoth.add(new int[]{i, j});
            }
        }
        return canFlowToBoth;
    }
    private void dfs(int[][] matrix, boolean[][] check, int prevHeight, int x, int y) {
        if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length 
                && matrix[x][y] >= prevHeight && !check[x][y] ) {
            check[x][y] = true;
            for(int[] move : moves) {
                dfs(matrix, check, matrix[x][y], x+move[0], y+move[1]);
            }
        }
    }
    public static void main(String[] args) {
    	PacificAtlanticWaterFlow solution = new PacificAtlanticWaterFlow();
        List<int[]> points = solution.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
        for(int[] point : points) {
            System.out.print("[" + point[0] + ", " + point[1] + "] ");
        }
    }
}
