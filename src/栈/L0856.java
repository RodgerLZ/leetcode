package 栈;

/**
 * [856. 括号的分数](https://leetcode-cn.com/problems/score-of-parentheses/)
 */
public class L0856 {
    public static int scoreOfParentheses(String S) {
        return dfs(S, 0, S.length());
    }

    private static int dfs(String str, int start, int end) {
        int bal = 0, res = 0;

        for (int i=start; i<end; i++) {
            char c = str.charAt(i);
            bal += c == '('? 1: -1;

            if (bal == 0) {
                if (i-start == 1) res += 1;
                else res += 2 * dfs(str, start+1, i);

                start = i+1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses(""));
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()(())"));
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}
