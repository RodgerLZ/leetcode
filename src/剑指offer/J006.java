package 剑指offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 */
public class J006 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> integers = new Stack<>();

        while (head!=null) {
            integers.push(head.val);
            head = head.next;
        }

        int size = integers.size();
        int[] ints = new int[size];
        for(int i = 0; i< size; i++) {
            ints[i] = integers.pop();
        }

        return ints;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;

        System.out.println(Arrays.toString(reversePrint(l1)));
    }
}
