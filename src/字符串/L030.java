package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 30. 串联所有单词的子串
 */
public class L030 {
    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s==null || s.isEmpty()) return result;

        if (words == null || words.length == 0) return result;

        int subStringLen = words[0].length() * words.length;
        if (s == null || s.length() < subStringLen) return result;

        for (int i=0; i+subStringLen<=s.length(); i++) {
            if (equalString(s.substring(i, i+subStringLen), words)) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * s的字符串长度与words的累计长度和一样
     * 判断s与words的任意一种组合是否相等，相等则返回true，否则返回false
     */
    private static boolean equalString(String s, String[] words) {

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        int wordLen = words[0].length();
        int index = 0;

        while (index + wordLen <= s.length()) {
            int endIndex = index + wordLen;
            String substring = s.substring(index, endIndex);
            if (!wordList.remove(substring)) return false;
            index = endIndex;
        }

        return (wordList.size() == 0);
    }

    public static void main(String[] args) {
        String[] words = {"word","good","best","word"};
        System.out.println(findSubstring("wordgoodgoodgoodbestword", words));

    }
}
