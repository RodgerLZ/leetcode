package 栈;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组
 */
public class L1441 {
    public List<String> buildArray(int[] target, int n) {

        List<String> res = new ArrayList<>();
        if (target.length == 0) return res;

        int maxLimit = target[target.length - 1];
        int i=0, j=1;

        while (i < target.length && j<=maxLimit){
            res.add("Push");
            int targetInt = target[i];
            if (j == targetInt) {
                i++;
            } else {
                res.add("Pop");
            }
            j++;
        }

        return res;
    }
}
