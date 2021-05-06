/**
 * 70. Climbing Stairs
 * 
 * https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    /**
     * Approach 2: Recursion with Memoization
     * 
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climbSubStairs(0, n, memo);
    }
    
    public int climbSubStairs(int i, int n, int memo[]) {
        if (i > n)
            return 0;
        if (i == n)
            return 1;
        if (memo[i] > 0)
            return memo[i];
        memo[i] = climbSubStairs(i + 1, n, memo) + climbSubStairs(i + 2, n, memo);
        return memo[i];
    }


    /**
     * Approach 3: Dynamic Programming
     * 
     * @param n
     * @return
     */
    public int climbStairsDp(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Approach 4: Fibonacci Number
     * 
     * @param n
     * @return
     */
    public int climbStairsFn(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(44));
        System.out.println(solution.climbStairsDp(44));
        System.out.println(solution.climbStairsFn(44));
    }
}