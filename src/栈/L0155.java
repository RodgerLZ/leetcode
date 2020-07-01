package 栈;

import java.util.LinkedList;

/**
 * 155. 最小栈
 */
public class L0155 {
    public LinkedList<Integer> l;
    public LinkedList<Integer> l2;

    public L0155() {
        l = new LinkedList<>();
        l2 = new LinkedList<>();
        l2.add(Integer.MAX_VALUE);
    }

    public void push(int x) {
        l.add(x);
        /**
         * 这题的关键在这里：用来获取最小值的栈，每次存储的值为（l2 top 与 x 的最小值）
         */
        l2.add(Math.min(l2.getLast(), x));
    }

    public void pop() {
        l.remove(l.size() - 1);
        l2.remove(l2.size() - 1);

    }

    public int top() {
        return l.get(l.size() - 1);
    }

    public int getMin() {
        return l2.getLast();
    }

    public static void main(String[] args) {
        L0155 l = new L0155();
        l.push(-2);
        l.push(0);
        l.push(-3);
        System.out.println(l.getMin());
        l.pop();
        System.out.println(l.top());
        System.out.println(l.getMin());
    }
}
