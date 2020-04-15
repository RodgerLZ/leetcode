package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 电话号码的字母组合
 */
public class L017 {
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) return new ArrayList<>();

        if (digits.length()==1) return getList(digits.charAt(0));

        return listCombination(getList(digits.charAt(0)), letterCombinations(digits.substring(1)));

    }

    private List<String> listCombination(List<String> list1, List<String> list2) {
        List<String> strings = new ArrayList<>();

        for (String s1:list1) {
            for(String s2:list2) {
                strings.add(s1+s2);
            }
        }

        return strings;
    }

    private List<String> getList(char ch) {
        switch (ch) {
            case '2': return Arrays.asList("a", "b", "c");
            case '3': return Arrays.asList("d", "e", "f");
            case '4': return Arrays.asList("g", "h", "i");
            case '5': return Arrays.asList("j", "k", "l");
            case '6': return Arrays.asList("m", "n", "o");
            case '7': return Arrays.asList("p", "q", "r", "s");
            case '8': return Arrays.asList("t", "u", "v");
            case '9': return Arrays.asList("w", "x", "y", "z");
            default: return new ArrayList<>();
        }
    }
}
