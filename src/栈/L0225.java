package 栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 */
public class L0225 {

    public Queue<Integer> q1;
    public Queue<Integer> q2;

    public L0225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (q1.size()>1) {
            q2.add(q1.poll());
        }

        int res = q1.poll();

        while (q2.size()>0) {
            q1.add(q2.poll());
        }

        return res;
    }

    public int top() {
        while (q1.size()>1) {
            q2.add(q1.poll());
        }

        int res = q1.poll();
        q2.add(res);

        while (q2.size()>0) {
            q1.add(q2.poll());
        }

        return res;
    }

    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        L0225 l = new L0225();
        l.push(1);
        l.push(2);
        System.out.println(l.top());
        System.out.println(l.pop());
        System.out.println(l.pop());
        System.out.println(l.empty());
    }
}
