package 字符串;

import java.util.ArrayList;

public class L537 {

    public static String complexNumberMultiply(String a, String b) {
        String[] complexNumber1 = a.split("\\+", 2);
        String[] complexNumber2 = b.split("\\+", 2);

        String[] i1 = complexNumber1[1].split("i");
        if (i1.length == 0) {
            complexNumber1[1] = "1";
        } else if (i1[0].equals("-")) {
            complexNumber1[1] = "-1";
        } else {
            complexNumber1[1] = i1[0];
        }

        String[] i2 = complexNumber2[1].split("i");
        if (i2.length == 0) {
            complexNumber2[1] = "1";
        } else if (i2[0].equals("-")) {
            complexNumber2[1] = "-1";
        } else {
            complexNumber2[1] = i2[0];
        }

        ArrayList<Integer> multiplyList = new ArrayList<>(4);
        for (String eachNum1: complexNumber1) {
            for (String eachNum2: complexNumber2) {
                int i = Integer.parseInt(eachNum1) * Integer.parseInt(eachNum2);
                multiplyList.add(i);
            }
        }

        return (multiplyList.get(0) - multiplyList.get(3))
        + "+"
        + (multiplyList.get(1) + multiplyList.get(2))
        + "i";
    }

    public static String complexNumberMultiplyByWeb(String a, String b) {

        String[] x = a.split("\\+|i");
        String[] y = b.split("\\+|i");

        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);

        return (a_real*b_real - a_img*b_img) + "+" + (a_real*b_img + a_img*b_real) + "i";
    }

    public static void main(String[] args) {
        System.out.println(complexNumberMultiply("1+i", "1+-i"));

        System.out.println(complexNumberMultiplyByWeb("1+1i", "1+-1i"));
    }
}
