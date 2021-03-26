package arithmetic.StringQuestion;

import java.util.HashMap;
import java.util.Map;

public class smallestContain {
    //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    //注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
    //    输入：s = "ADOBECODEBANC", t = "ABC"
    //    输出："BANC"
    private static String word="ADOBECODEBANC";
    private static String target="ABC";
    public static void main(String[] args) {
        fun(word);
    }

    public static String fun(String sourceString){
        char[] sources = sourceString.toCharArray();
        char[] targets = target.toCharArray();
        Map<Character, Boolean>targetMap=new HashMap<>();
        for (char source:sources){

        }
        return "ABC";
    }
}
