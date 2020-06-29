package 栈;

import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class L0020 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<String> st = new Stack<>();

        for (char c: chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    st.push(String.valueOf(c));
                    break;
                case ')':
                    if (st.isEmpty()) return false;
                    String p1 = st.pop();
                    if (!p1.equals("(")) return false;
                    break;
                case ']':
                    if (st.isEmpty()) return false;
                    String p2 = st.pop();
                    if (!p2.equals("[")) return false;
                    break;
                case '}':
                    if (st.isEmpty()) return false;
                    String p3 = st.pop();
                    if (!p3.equals("{")) return false;
                    break;
                default:
                    return false;
            }
        }

        return st.isEmpty();
    }
}
