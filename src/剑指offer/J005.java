package 剑指offer;

/**
 * 面试题05. 替换空格
 */
public class J005 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c:chars){
            sb.append(c==' '? "%20":c);
        }

        return sb.toString();
    }
}
