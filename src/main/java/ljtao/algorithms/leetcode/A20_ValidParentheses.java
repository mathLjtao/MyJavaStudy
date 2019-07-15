package ljtao.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:   输入: "()"    输出: true
示例 2:   输入: "()[]{}"    输出: true
示例 3:   输入: "(]"    输出: false
示例 4:   输入: "([)]"  输出: false
示例 5:   输入: "{[]}"  输出: true
 */
public class A20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));

    }
    /*
    (,[,{ 这些就存入栈
    ),],} 就从栈顶取出元素，然后结合，看是否等于() ,[] ,{}
     */
    public static boolean isValid(String s) {
        //ArrayDeque可以当成栈或者队列来使用，主要看用什么方法
        ArrayDeque<String> stack=new ArrayDeque<>();
        String pre;
        String com;
        int len=s.length();
        if(len%2!=0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            pre=s.substring(i,i+1);
            if("(".equals(pre)||"[".equals(pre)||"{".equals(pre))
                stack.push(pre);
            if(")".equals(pre)||"]".equals(pre)||"}".equals(pre)){
                if(stack.isEmpty())
                    return false;
                com=stack.pop()+pre;
                if("()".equals(com)||"[]".equals(com)||"{}".equals(com))
                    continue;
                else
                    return false;
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    /*
    网上的方法，很简洁，就是去掉一个个的(){}[]
     */
    public boolean isValid1(String s) {

        while (s.contains("{}")||s.contains("[]")|| s.contains("()")){

            if(s.contains("{}")) s=s.replace("{}","");
            if(s.contains("()")) s=s.replace("()","");
            if(s.contains("[]")) s=s.replace("[]","");

        }

        return s.isEmpty();
    }
    /*
    网上方案二
     */
    public static boolean isValid2(String s) {
        if(s.length()%2!=0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
