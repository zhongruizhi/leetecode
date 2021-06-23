/**
 * 63. Unique Paths II
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsII {

    /**
     * My original solution
     * 
     * @param obstacleGrid
     * @return
     */
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


    /**
     * Optimaized solution
     * https://leetcode.com/problems/unique-paths-ii/solution/
     * 
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
        System.out.println(solution.uniquePathsWithObstacles2(obstacleGrid)); 
    }
}