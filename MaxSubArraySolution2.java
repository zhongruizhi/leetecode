/**
 * https://leetcode.com/problems/maximum-subarray/solution/
 * Kadane's Algorithm
 */
class MaxSubArraySolution2 {
    public int maxSubArray(int[] nums) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        for (int i = 0; i < nums.length; i++) {
            localMax =  Math.max(nums[i], localMax + nums[i]);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {

        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArraySolution2 solution = new MaxSubArraySolution2();
        System.out.println(solution.maxSubArray(input));
    }
}