package 剑指offer;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 */
public class J006 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> integers = new Stack<>();

        while (head!=null) {
            integers.push(head.val);
            head = head.next;
        }

        int[] ints = new int[integers.size()];
        for(int i=0; i<integers.size(); i++) {
            ints[i] = integers.pop();
        }

        return ints;
    }
}
