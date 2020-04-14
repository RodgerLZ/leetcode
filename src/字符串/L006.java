package 字符串;

public class L006 {

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        int sLength = s.length();
        StringBuilder result = new StringBuilder();

        for (int i=0; i<numRows; i++) {

            boolean flag = true;
            int j = 1;

            while (flag) {
                int nextIndex;
                if (i == 0) {
                    nextIndex = (numRows-1) * (2*j - 2);
                } else if ( i == numRows-1) {
                    nextIndex = (numRows-1) * (2*j-1);
                } else {
                    nextIndex = i + ((j/2)*2) * (numRows-1-i) + (((j-1)/2)*2) * i;
                }

                if (nextIndex< sLength){
                    j++;
                    result.append(s.charAt(nextIndex));
                } else {
                    flag=false;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
