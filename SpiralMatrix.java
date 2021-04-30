import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * Layer-by-Layer
 */

import java.util.List;
import java.util.ArrayList;

public class  SpiralMatrix {

    /**
     *  Layer-by-Layer
     * 
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int rt = 0, rb = matrix.length - 1;
        int cl = 0, cr = matrix[0].length - 1;
        while (rt <= rb && cl <= cr) {
            for (int c = cl; c <= cr; c++)  ans.add(matrix[rt][c]);
            for (int r = rt + 1; r <= rb; r++) ans.add(matrix[r][cr]);
            if (rt < rb && cl < cr) {
                for (int c = cr - 1; c > cl; c--) ans.add(matrix[rb][c]);
                for (int r = rb; r > rt; r--) ans.add(matrix[r][cl]);
            }
            rt++;
            rb--;
            cl++;
            cr--;
        }

        return ans;
    }

    public static void main(String[] args) {
        SpiralMatrix solution = new SpiralMatrix();
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(solution.spiralOrder(matrix));
    }

}