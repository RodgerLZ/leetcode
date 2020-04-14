package 字符串;

public class L012 {
    public static String intToRoman(int num) {

        int mNum = num / 1000;
        int mod = num % 1000;
        int dNum = mod / 500;
        mod = mod % 500;
        int cNum = mod / 100;
        mod = mod % 100;
        int lNum = mod / 50;
        mod = mod % 50;
        int xNum = mod / 10;
        mod = mod % 10;
        int vNum = mod / 5;
        int iNum = mod % 5;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<mNum; i++) {
            sb.append("M");
        }
        for (int i=0; i<dNum; i++) {
            sb.append("D");
        }
        for (int i=0; i<cNum; i++) {
            sb.append("C");
        }
        for (int i=0; i<lNum; i++) {
            sb.append("L");
        }
        for (int i=0; i<xNum; i++) {
            sb.append("X");
        }
        for (int i=0; i<vNum; i++) {
            sb.append("V");
        }
        for (int i=0; i<iNum; i++) {
            sb.append("I");
        }

        String s = sb.toString();
        return s
                .replaceAll("DCCCC", "CM")
                .replaceAll("CCCC", "CD")
                .replaceAll("LXXXX", "XC")
                .replaceAll("XXXX", "XL")
                .replaceAll("VIIII", "IX")
                .replaceAll("IIII", "IV");
    }

    public static String intToRomanWeb(int num) {
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index<13) {
            if (num >= nums[index]) {
                num = num - nums[index];
                sb.append(romans[index]);
            } else {
                index++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(99));
        System.out.println(intToRomanWeb(99));
        String a = "a";
        a.concat("b");
        String.valueOf(1);
    }
}
