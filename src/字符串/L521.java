package 字符串;

public class L521 {

    public int findLUSlength(String a, String b) {

        if (a.length() != b.length()) {
            return Math.max(a.length(), b.length());
        }

        if (a.contains(b)) {
            return -1;
        } else {
            return a.length();
        }
    }

    public int findLUSlengthByWeb(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }

        return Math.max(a.length(), b.length());
    }
}
