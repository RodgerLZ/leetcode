package 动态规划;

/**
 * 392. 判断子序列
 */
public class L0392 {
    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() ==0) return true;

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        int tIndex = 0;
        for (int i=0; i<t.length(); i++) {
            if (charsT[i] == charsS[tIndex]) {
                tIndex++;
            }
            if (tIndex == s.length()) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
