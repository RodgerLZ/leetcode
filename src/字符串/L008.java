package 字符串;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L008 {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();

        String pattern = "^[+-]?\\d+";

        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(str);

        if (matcher.find()) {
            boolean ifPlus = true;
            String numString = matcher.group();
            if (numString.startsWith("+")) {
                numString = numString.substring(1);
            } else if (numString.startsWith("-")) {
                ifPlus = false;
                numString = numString.substring(1);
            }

            int num;
            try {
                num = Integer.parseInt(numString);
            } catch (NumberFormatException e) {
                return ifPlus?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            return ifPlus?num:-1*num;
        } else {
            return 0;
        }
    }

    public static int myAtoiByWeb(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        int length = str.length();
        int index = 0;
        boolean positive = true;

        while (index < length && str.charAt(index) == ' ') {
            index ++;
        }

        if (index == length) return 0;

        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            positive = false;
            index++;
        } else if (!Character.isDigit(str.charAt(index))) {
            return 0;
        }

        int result = 0;
        int limit = positive?-Integer.MAX_VALUE:Integer.MIN_VALUE;
        while (index<length && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            if (result < (limit + digit) / 10) {
                return -limit;
            }

            // 注意这里用的是减法，可以参照JDK中Integer的处理方式
            result = result * 10 - digit;
            index++;
        }

        return result * (positive?-1:1);
    }

    public static void main(String[] args) {
        String str = "     2147483648";

        System.out.println(myAtoi(str));
        System.out.println(myAtoiByWeb(str));

//        System.out.println((Integer.MIN_VALUE-4)/10 * (false?1:-1));
    }
}