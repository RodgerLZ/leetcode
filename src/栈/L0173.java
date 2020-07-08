package 栈;

import java.util.*;

/**
 * 173. 二叉搜索树迭代器
 * 二叉搜索树的中序遍历为递增序列
 *
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/solution/er-cha-sou-suo-shu-die-dai-qi-by-leetcode/
 * 官方题解中有个受控递归的方式，可以不借助额外的存储空间。
 */
public class L0173 {

    private List<Integer> vales;
    private int index = -1;
    private int vSize;

    public L0173(TreeNode root) {
        vales = dfs(root);
        vSize = vales.size();
    }

    public int next() {
        return vales.get(++index);
    }

    public boolean hasNext() {
        return index < vSize-1;
    }

    private List<Integer> dfs(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (root.left != null) res.addAll(dfs(root.left));
        res.add(root.val);
        if (root.right != null) res.addAll(dfs(root.right));

        return res;
    }

}
