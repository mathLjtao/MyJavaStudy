package ljtao.algorithms.leetcode;
/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */
public class A14_LongestCommonPrefix {
    public static void main(String[] args) {
        String s="asdfgh";
        String[] strs=new String[]{"aaoo","aab","aay"};
        System.out.println(s.substring(5,6));
        System.out.println(longestCommonPrefix1(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        int min=strs[0].length();
        //先算出数组中长度最短是多少
        for (String s:strs){
            if(s==null || "".equals(s))
                return "";
            min= min<s.length()? min:s.length();
        }
        String c="";
        String first="";
        for (int i = 0; i < min; i++) {
            first=strs[0].substring(0,i+1);
            for (int j=1;j<strs.length;j++){
                c=strs[j].substring(0,i+1);
                if(!c.equals(first))
                    return strs[0].substring(0,i);
            }
        }

        return first;
    }
    /*
    网上的做法,
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs==null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            //判断是否包含
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }
}
