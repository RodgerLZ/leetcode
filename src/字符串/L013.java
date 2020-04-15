package 字符串;

public class L013 {
    public int romanToInt(String s) {

        if (s==null || s.length()==0) return 0;

        int index = 0;
        int length = s.length();
        int result = 0;

        while (index < length) {
            if (s.charAt(index) == 'I') {
                if (index+1<length && s.charAt(index+1) == 'V') {
                    result += 4;
                    index++;
                } else if (index+1<length && s.charAt(index+1) == 'X') {
                    result += 9;
                    index++;
                } else result +=1;
                index++;
                continue;
            }

            if (s.charAt(index) == 'X') {
                if (index+1<length && s.charAt(index+1) == 'L') {
                    result += 40;
                    index++;
                } else if (index+1<length && s.charAt(index+1) == 'C') {
                    result += 90;
                    index++;
                } else result +=10;
                index++;
                continue;
            }

            if (s.charAt(index) == 'C') {
                if (index+1<length && s.charAt(index+1) == 'D') {
                    result += 400;
                    index++;
                } else if (index+1<length && s.charAt(index+1) == 'M') {
                    result += 900;
                    index++;
                } else result +=100;
                index++;
                continue;
            }

            result += getValue(s.charAt(index));
            index ++;
        }

        return result;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'V': return 5;
            case 'L': return 50;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
