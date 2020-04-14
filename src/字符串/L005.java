package 字符串;

public class L005 {

    // 可以优化的地方，在寻找最长回文子串的时候，可以只记录开始和结束的索引
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int n = s.length();

        String longestString = "";

        for (int i=1; 0<=i && i<n; i++) {
            String tempString = String.valueOf(s.charAt(i));
            for (int j=1; 0<=i-j && i+j<n; j++) {
                if (s.charAt(i-j) == s.charAt(i+j)) {
                    tempString = s.charAt(i-j) + tempString + s.charAt(i+j);
                } else {
                    break;
                }
            }
            longestString = longestString.length() > tempString.length()? longestString:tempString;
        }

        for (int i=1; 0<=i && i<n; i++) {
            String tempString = "";
            for (int j=1; 0<=i-j && i+j-1<n; j++) {
                if (s.charAt(i-j) == s.charAt(i+j-1)) {
                    tempString = s.charAt(i-j) + tempString + s.charAt(i+j-1);
                } else {
                    break;
                }
            }
            longestString = longestString.length() > tempString.length()? longestString:tempString;
        }

        return longestString;
    }

    /**
     * 动态规划的方式解决最大回文子串
     */
    public static String longestPalindromeDp(String s) {

        if (s == null || s.length() < 2) return s;

        int startIndex = 0;
        int maxLength = 1;
        int strLength = s.length();
        boolean[][] dp = new boolean[strLength][strLength];

        for (int l=1; l<strLength; l++) {
            for(int r=0; r<l; r++) {
                if (s.charAt(r) == s.charAt(l)) {
                    dp[r][l] = l-r<=2 || dp[r+1][l-1];
                } else {
                    dp[r][l] = false;
                }

                if (dp[r][l] && l-r+1>maxLength) {
                    startIndex = r;
                    maxLength = l-r+1;
                }
            }
        }

        return s.substring(startIndex, startIndex+maxLength);
    }

    /**
     * 改进后的中心索引
     * @param s
     * @return
     */
    public static String longestPalindromeNew(String s) {

        if (s == null || s.length() < 2) return s;

        int startIndex = 0;
        int maxLength = 1;
        int strLength = s.length();

        for (int i=1; i<strLength; i++) {

            int r = i;
            int l = i;

            int curLength = 1;

            while (r-1>=0 && s.charAt(r-1) == s.charAt(i)) {
                r--;
                curLength++;
            }

            while (l+1<strLength && s.charAt(l+1) == s.charAt(i)) {
                l++;
                curLength++;
            }

            while (0<=r-1 && l+1<strLength) {
                if (s.charAt(r-1) == s.charAt(l+1)) {
                    curLength += 2;
                    r--;
                    l++;
                } else {
                    if (curLength>maxLength) {
                        maxLength = curLength;
                        startIndex = r;
                    }
                    break;
                }
            }

            if (curLength>maxLength) {
                maxLength = curLength;
                startIndex = r;
            }
        }

        return s.substring(startIndex, startIndex+maxLength);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindromeDp("bb"));
        System.out.println(longestPalindromeNew("bb"));
    }
}
