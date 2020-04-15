package 字符串;

/**
 * 28.实现 strStr()
 */
public class L028 {
    public int strStr(String haystack, String needle) {

        if (needle == null || needle.isEmpty()) return 0;

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        if (haystackLength < needleLength) return -1;

        int maxIndex = haystackLength - needleLength;

        for (int i=0; i<=maxIndex; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (needleLength == 1) return i;
                for (int j=1; j<needleLength && haystack.charAt(i+j) == needle.charAt(j); j++) {
                    if (j==needleLength-1) return i;
                }
            }
        }

        return -1;
    }
}
