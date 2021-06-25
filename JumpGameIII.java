/**
 * 1306. Jump Game III
 * https://leetcode.com/problems/jump-game-iii/
 */
public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        
    }

    public static void main(String[] args) {
       JumpGameIII solution = new JumpGameIII();
       int[] arr1 = {4, 2, 3, 0, 3, 1, 2};
       int start1 = 5;
       //true 
       System.out.println(solution.canReach(arr1, start1));
       int[] arr2 = {4, 2, 3, 0, 3, 1, 2};
       int start2 = 0;
       //true
       System.out.println(solution.canReach(arr2, start2));
       int[] arr3 = {3, 0, 2, 1, 2};
       int start3 = 2;
       //false
       System.out.println(solution.canReach(arr3, start3)); 
    }
}