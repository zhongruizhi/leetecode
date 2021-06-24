/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/ 
 */
public class JumpGame {

    /**
     * https://towardsdatascience.com/tackling-jump-game-problems-leetcode-e0a718e7dfba
     */
    public boolean canJump(int[] nums) {

        int i = 0, maxReach = 0;
        while (i < nums.length && i <= maxReach) {
            maxReach = Math.max(i + nums[i], maxReach);
            i++;
        }
        
        return i == nums.length ? true : false;
    }
   
    /**
     * https://towardsdatascience.com/tackling-jump-game-problems-leetcode-e0a718e7dfba
     */
    public boolean canJump2(int[] nums) {

        int lastreach = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--)
        {
            if(i+nums[i] >= lastreach) {
                lastreach = i;
            }
        }
        return lastreach == 0 ? true : false;
    }
    public static void main(String[] args) {
        JumpGame solution = new JumpGame();
        int[] numsTrue = {2, 3, 1, 1, 4};
        int[] numsFalse = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(numsTrue));
        System.out.println(solution.canJump(numsFalse));
        System.out.println(solution.canJump2(numsTrue));
        System.out.println(solution.canJump2(numsFalse));
    }
}