import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[2][triangle.size()];
        for(int i = 0 ; i < triangle.size(); i++) {
            dp[(triangle.size()-1)%2][i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i = triangle.size()-2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[i%2][j] = Math.min(dp[(i+1)%2][j], dp[(i+1)%2][j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
    	Triangle solution = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        System.out.println(solution.minimumTotal(triangle)); //11
    }
}
