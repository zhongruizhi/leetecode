import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 */
class  GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    
    private void backtrack(List<String> res, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            res.add(cur);
            return;
        }
        if (open < max) {
            backtrack(res, cur + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(res, cur + ")", open, close + 1, max);
        }
    }
    
    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}