/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 || j == 0 ) {
                    grid[i][j] = 1;
                    if (obstacleGrid[i][j] == 1) {
                        grid[i][j] = 0;
                    }
                    if (i > 0 && grid[i - 1][j] == 0) {
                        grid[i][j] = 0;
                    }
                    if (j > 0 && grid[i][j - 1] == 0) {
                        grid[i][j] = 0;
                    }
                } else if (obstacleGrid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = (obstacleGrid[i - 1][j] == 1 ? 0 : grid[i - 1][j]) + (obstacleGrid[i][j - 1] == 1 ? 0 : grid[i][j - 1]);
                }
            }
        }

        return grid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }


    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}