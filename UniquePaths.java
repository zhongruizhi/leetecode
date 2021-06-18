/**
 * 62. Unique Paths
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
       int[][] grid = new int[m][n];
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (i == 0 || j == 0) {
                   grid[i][j] = 1;
               } else {
                   grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
               }
           }
       } 
       return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(3, 7));
    }
}