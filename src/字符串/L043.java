package 字符串;

public class L043 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int num1Len = num1.length();
        int num2Len = num2.length();

        int[] ints = new int[num1Len + num2Len + 1];
        for (int i=1; i<=num1Len; i++) {
            // 通过ascii码计算数值
            int n1 = num1.charAt(num1Len - i) - '0';
            for (int j=1; j<=num2Len; j++) {
                int n2 = num2.charAt(num2Len - j) - '0';
                int num = n1 * n2;
                int i1 = num % 10; // 个位数
                int i2 = num / 10; // 十位数

                int index = i + j - 2;
                int r1 = ints[index];
                int r2 = ints[index+1];
                int r3 = ints[index+2];

                ints[index] = (i1 + r1) >= 10 ? (i1 + r1) % 10 : (i1 + r1);
                int i3 = r2 + i2 + (i1 + r1) / 10;
                ints[index + 1] = i3 >= 10 ? i3 % 10 : i3;
                ints[index + 2] = r3 + i3 / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i=1; i <= ints.length; i++) {
            int integer = ints[ints.length - i];
            if (integer!=0) {
                flag = true;
            }

            if (flag) sb.append(integer);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
        System.out.println(multiply("3","4"));
        System.out.println(multiply("12345","4"));
        System.out.println(multiply("9999","999"));
    }
}
