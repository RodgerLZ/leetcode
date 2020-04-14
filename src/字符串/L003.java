package 字符串;

import java.util.ArrayList;
import java.util.List;

public class L003 {

    public static int lengthOfLongestSubstring(String s) {

        if (s==null || s.length() == 0) {
            return 0;
        }

        List<String> longestSubString = new ArrayList<>();
        int pointer = -1;
        int maxLength = 0;
        int eachSubStringLength = 0;
        for (int i=0; i<s.length(); i++) {
            char eachChar = s.charAt(i);
            int subIndex = getIndex(longestSubString, String.valueOf(eachChar));
            if (subIndex == (-1)) {
                eachSubStringLength +=1;
                longestSubString.add(String.valueOf(eachChar));
            } else {
                pointer = pointer + subIndex;
                i = pointer;
                maxLength = Math.max(maxLength, eachSubStringLength);
                longestSubString = new ArrayList<>();
                eachSubStringLength = 0;
            }
        }

        return Math.max(maxLength, eachSubStringLength);
    }

    private static int getIndex(List<String> longestSubString, String s) {
        for (int i=0; i<longestSubString.size(); i++) {
            if (longestSubString.get(i).equals(s)) return i+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
