package arithmetic.backDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {
    //存放最终结果
    static List<String> res = new ArrayList<>();
    //存放临时结果
    static StringBuffer path = new StringBuffer();
    //使用HashMap存放字符与字符串对应关系
    static Map<Character,String> phoneMap = new HashMap();

    public static void main(String[] args) {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        letterCombinations2("345");
        System.out.println(res.toString());
    }

    public static List<String> letterCombinations(String digits) {
        //对输入进行判断
        if(digits.length() == 0){
            return res;
        }
        //回溯
        backtraking(digits,0);
        //返回结果
        return res;
    }

    public static void backtraking(String digits,int index) {
        //终止条件："abc"遍历完成。
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        //获得index对应的数字
        char digit = digits.charAt(index);
        //获得数字对应的字符串
        String letter = phoneMap.get(digit);
        //遍历字符串中的字符
        for (int i = 0; i < letter.length(); i++) {
            //存入
            path.append(letter.charAt(i));
            //递归
            backtraking(digits, index + 1);
            //回溯
            path.deleteCharAt(index);
        }
    }

    public static List<String> letterCombinations2(String digits) {
        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;
        findCombination2(digits, 0, "");
        return res;
    }

    private static void findCombination2(String digits, int index, String s){
        if(index == digits.length()){
            res.add(s);
            return;
        }
        Character digit = digits.charAt(index);
        String letters =phoneMap.get(digit);
        for(int i = 0 ; i < letters.length() ; i ++){
            findCombination2(digits, index+1, s + letters.charAt(i));
        }
        return;
    }


}
