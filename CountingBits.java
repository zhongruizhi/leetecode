/**
 * https://leetcode.com/problems/counting-bits/
 * 338. Counting Bits
 */
import java.util.Arrays;

public class CountingBits {
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

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        System.out.println(Arrays.toString(solution.countBits(5)));
    }
}