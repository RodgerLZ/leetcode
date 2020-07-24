package 栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [636. 函数的独占时间](https://leetcode-cn.com/problems/exclusive-time-of-functions/)
 */
public class L0636 {

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] res = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int preTime = 0;

        for (String s:logs) {
            String[] strs = s.split(":");
            int tId = Integer.parseInt(strs[0]);
            int time = Integer.parseInt(strs[2]);

            if (deque.isEmpty()) {
                deque.addLast(tId);
                preTime = time;
                continue;
            }

            Integer preId = deque.peekLast();
            if (strs[1].equals("start")) {
                res[preId] += time - preTime;
                deque.addLast(tId);
                preTime = time;
                continue;
            }

            deque.removeLast();
            res[preId] += time - preTime + 1;
            preTime = time + 1;
        }

        return res;
    }

}
