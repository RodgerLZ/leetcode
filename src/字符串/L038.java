package 字符串;

/**
 * 38. 外观数列
 */
public class L038 {

    public static String countAndSay(int n) {

        if (n == 1) return "1";

        String preStr = countAndSay(n-1);
        int preLen = preStr.length();
        StringBuilder sb = new StringBuilder();

        int count = 0;
        char preChar = preStr.charAt(0);
        for (int i=0; i<preLen; i++) {
            char c = preStr.charAt(i);
            if (c == preChar) {
                count++;
            } else {
                sb.append(count).append(preChar);
                preChar = c;
                count = 1;
            }
        }
        sb.append(count).append(preChar);

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
