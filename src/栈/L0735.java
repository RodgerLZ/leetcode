package 栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [735. 行星碰撞](https://leetcode-cn.com/problems/asteroid-collision/)
 */
public class L0735 {
    public static int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> deque = new LinkedList<>();
        for(int i: asteroids) {
            if (i>0) {
                deque.addLast(i);
                continue;
            }

            if (deque.isEmpty()) {
                deque.addLast(i);
                continue;
            }

            while (!deque.isEmpty()) {
                Integer preI = deque.peekLast();

                if (preI < 0) {
                    deque.addLast(i);
                    break;
                }

                if (preI > -i) {
                    break;
                } else if (preI == -i) {
                    deque.removeLast();
                    break;
                } else {
                    deque.removeLast();
                    if (deque.isEmpty()) {
                        deque.addLast(i);
                        break;
                    }
                }
            }
        }

        int len = deque.size();
        int[] res = new int[len];
        for (int i=0; i<len; i++) {
            Integer j = deque.removeFirst();
            res[i] = j;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{1, -2, -2, -2})));
    }
}
