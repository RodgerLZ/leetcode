package 字符串;

public class L014 {
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        boolean flag = true;
        int index = 0;
        char eachChar;
        StringBuilder sb = new StringBuilder();

        while (flag) {

            if (index >= strs[0].length()) break;
            eachChar = strs[0].charAt(index);

            for (String str:strs) {
                if (index >= str.length() || eachChar != str.charAt(index)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                index++;
                sb.append(eachChar);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arg1 = {"aa","a"};
        System.out.println(longestCommonPrefix(arg1));
    }
}
