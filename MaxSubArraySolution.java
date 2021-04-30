/**
 * https://leetcode.com/problems/maximum-subarray/solution/
 * Brute force
 */
class MaxSubArraySolution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int current = 0;
            for (int j = i; j < nums.length; j++) {
                current += nums[j];
                max = Math.max(max, current);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArraySolution solution = new MaxSubArraySolution();
        System.out.println(solution.maxSubArray(input));
    }
}