/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    /**
     * https://towardsdatascience.com/tackling-jump-game-problems-leetcode-e0a718e7dfba
     * 
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }
        int maxReach = nums[0];
        int steps = nums[0];
        int jumps = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            maxReach = Math.max(i + nums[i], maxReach);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }

        return jumps + 1;
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums1));
        System.out.println(solution.jump(nums2));
    }
}