package 栈;

/**
 * 844. 比较含退格的字符串
 */
public class L0844 {
    /**
     * 双指针的解法
     */
    public static boolean backspaceCompare(String S, String T) {
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();

        int s = sChars.length - 1;
        int t = tChars.length - 1;

        int skipS = 0, skipT = 0;

        while (s>=0 || t>=0) {
            while (s>=0) {
                if (sChars[s] == '#') {
                    skipS++;
                    s--;
                } else if (skipS>0) {
                    s--;
                    skipS--;
                } else {
                    break;
                }
            }

            while (t>=0) {
                if (tChars[t] == '#') {
                    skipT++;
                    t--;
                } else if (skipT>0) {
                    t--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (s>=0 && t>=0 && sChars[s] != tChars[t]) return false;

            if ((s>=0) != (t>=0)) return false;

            s--;
            t--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("bbb", "bbb#"));
    }
}
