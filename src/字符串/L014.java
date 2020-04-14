package 字符串;

/**
 * 查找最长公共前缀
 */
// TODO 使用树的算法
public class L014 {
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        boolean flag = true;
        int index = 0;
        char eachChar;
        StringBuilder sb = new StringBuilder();

        while (flag) {

            if (index >= strs[0].length()) break;
            eachChar = strs[0].charAt(index);

            for (String str:strs) {
                if (index >= str.length() || eachChar != str.charAt(index)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                index++;
                sb.append(eachChar);
            }
        }

        return sb.toString();
    }

    /**
     * 水平扫描法
     */
    public static String longestCommonPrefix01(String[] strs) {

        if (strs == null || strs.length==0) return "";

        String commonPrefix = strs[0];
        for (int index=1; index<strs.length; index++) {
            while (strs[index].indexOf(commonPrefix) != 0) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length()-1);
                if (commonPrefix.isEmpty()) return "";
            }
        }

        return commonPrefix;
    }

    /**
     * 垂直扫描
     * 此处和自己的方法类似，通过subString而非StringBuilder的方式获取commonPrefix
     */
    public static String longestCommonPrefix02(String[] strs) {

        if (strs == null || strs.length==0) return "";

        for(int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for(int j=1; j<strs.length; j++) {
                if (i==strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0];
    }

    /**
     * 分治
     */
    public static String longestCommonPrefix03(String[] strs) {

        if (strs == null || strs.length==0) return "";

        return longestCommonPrefix03(strs, 0, strs.length-1);
    }

    private static String longestCommonPrefix03(String[] strs, int l, int r){

        if (l==r) return strs[l];

        int mid = (l + r) /2;
        String lcpLeft = longestCommonPrefix03(strs, l, mid);
        String lcpRight = longestCommonPrefix03(strs, mid+1, r);

        return longestCommonPrefix03(lcpLeft, lcpRight);
    }

    private static String longestCommonPrefix03(String lcpLeft, String lcpRight){

        int min = Math.min(lcpLeft.length(), lcpRight.length());

        for(int i=0; i<min; i++){
            if(lcpLeft.charAt(i) != lcpRight.charAt(i)) return lcpLeft.substring(0,i);
        }

        return lcpLeft.substring(0,min);
    }


    public static void main(String[] args) {
        String[] arg1 = {"aa","a"};
        System.out.println(longestCommonPrefix(arg1));
        System.out.println(longestCommonPrefix01(arg1));
        System.out.println(longestCommonPrefix02(arg1));
        System.out.println(longestCommonPrefix03(arg1));
    }
}
