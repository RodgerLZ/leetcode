package 字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 227. 基本计算器 II
 */
public class L0227 {
    // 通过一个栈来实现
    public static int calculateWeb(String s) {
        char[] chars = s.toCharArray();

        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<chars.length; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                int num =  ch - '0';
                while (i+1<chars.length && Character.isDigit(chars[i+1])) {
                    num = num * 10 + (chars[++i] - '0');
                }
                stack.push(num * sign);
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '*') {
                int op1 = stack.pop();
                int op2 = 0;

                while (i+1<chars.length) {
                    if (chars[i+1] == ' ') {
                        i++;
                        continue;
                    }
                    else if (Character.isDigit(chars[i+1])) {
                        int num =  chars[++i] - '0';
                        while (i+1<chars.length && Character.isDigit(chars[i+1])) {
                            num = num * 10 + (chars[++i] - '0');
                        }
                        op2 = num;
                        break;
                    }
                }

                stack.push(op1 * op2);
            } else if (ch == '/') {
                int op1 = stack.pop();
                int op2 = 1;

                while (i+1<chars.length) {
                    if (chars[i+1] == ' ') {
                        i++;
                        continue;
                    }
                    else if (Character.isDigit(chars[i+1])) {
                        int num =  chars[++i] - '0';
                        while (i+1<chars.length && Character.isDigit(chars[i+1])) {
                            num = num * 10 + (chars[++i] - '0');
                        }
                        op2 = num;
                        break;
                    }
                }

                stack.push(op1 / op2);
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public static int calculate(String s) {

        List<String> l1 = new ArrayList<>();
        List<String> l2 = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (int i=0; i < chars.length; i++) {

            char ch = chars[i];

            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i+1<chars.length && Character.isDigit(chars[i+1])) {
                    cur = cur * 10 + chars[++i]-'0';
                }
                l1.add(String.valueOf(cur));
            } else if (ch != ' ') {
                l1.add(String.valueOf(ch));
            }
        }

        for (int i=0; i<l1.size(); i++) {
            String str = l1.get(i);
            if (str.equals("*")) {
                int op1 = Integer.parseInt(l2.get(l2.size()-1));
                int op2 = Integer.parseInt(l1.get(++i));
                l2.remove(l2.size()-1);
                l2.add(String.valueOf(op1*op2));
            } else if (str.equals("/")) {
                int op1 = Integer.parseInt(l2.get(l2.size()-1));
                int op2 = Integer.parseInt(l1.get(++i));
                l2.remove(l2.size()-1);
                l2.add(String.valueOf(op1/op2));
            } else {
                l2.add(str);
            }
        }

        int res = Integer.parseInt(l2.get(0));
        for (int i=1; i<l2.size()-1; i++) {
            if (l2.get(i).equals("+")) {
                res += Integer.parseInt(l2.get(++i));
            } else {
                res -= Integer.parseInt(l2.get(++i));
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(calculateWeb("12-3*4"));
    }
}
