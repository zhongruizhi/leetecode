/**
 * https://leetcode.com/problems/counting-bits/
 * 338. Counting Bits
 */
import java.util.Arrays;

public class CountingBits {
    /**
     * Brute Force
     * 
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = 0;
            int quotient = i;
            while (quotient > 0) {
                int remainder = quotient % 2;
                ans[i] += remainder;
                quotient = quotient / 2;
            }
        }
        return ans;
    }

    /**
     * Dynamic Programming
     * 
     * @param n
     * @return
     */
    public int[] countBitsDp(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i / 2] + i % 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        System.out.println(Arrays.toString(solution.countBits(5)));
        System.out.println(Arrays.toString(solution.countBitsDp(5))); 
    }
}