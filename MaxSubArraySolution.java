/**
 * https://leetcode.com/problems/maximum-subarray/solution/
 * 
 */
class MaxSubArraySolution {

    /**
     * Brute force
     * 
     * @param nums
     * @return
     */
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

    /**
     * Kadane's Algorithm
     * 
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
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
        MaxSubArraySolution solution = new MaxSubArraySolution();
        System.out.println(solution.maxSubArray(input));
        System.out.println(solution.maxSubArray2(input));
    }
}