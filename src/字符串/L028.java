package 字符串;

/**
 * 28.实现 strStr()
 */
public class L028 {

    /**
     * 双指针算法
     */
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

    /**
     * Rabin Karp 算法
     * 通过滑动窗口 + 自定义hashcode的算法，时间复杂度为o(n)
     */
    public static int strStr01(String haystack, String needle) {

        // 所需查找的目标字符串为空时
        if (needle==null || needle.length()==0) return 0;

        int sLen = haystack.length();
        int tLen = needle.length();

        if (sLen < tLen) return -1;

        // 计算hashCode取模时用，防止溢出
        long modulus = (long) Math.pow(2, 31);
        // 用于计算hash值，这里题目中有26个英文字母，所以选26
        int a = 26;

        // 计算haystack和needle的hash值
        long sHa = 0, tHa = 0;
        for (int i=0; i<tLen; i++) {
            sHa = (sHa * a + charToInt(haystack, i)) % modulus;
            tHa = (tHa * a + charToInt(needle, i)) % modulus;
        }

        if (sHa == tHa) return 0;

        // 求出a**tLen % modulus
        long aTLen = 1;
        for (int i=1; i<=tLen; i++) aTLen = aTLen * a % modulus;

        // 每次向后滑动一个字符，计算滑动后窗口对应的字符串的hashCode
        for (int i=1; i<sLen-tLen+1; i++) {
            sHa = (sHa * a - charToInt(haystack, i-1)*aTLen + charToInt(haystack, i+tLen-1)) % modulus;
            if (sHa == tHa) return i;
        }

        return -1;
    }

    private static int charToInt(String str, int index) {
        return str.charAt(index) - 'a';
    }

    public static void main(String[] args) {
        System.out.println(strStr01("a","a"));
    }
}
