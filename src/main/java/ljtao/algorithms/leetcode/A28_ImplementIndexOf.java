package ljtao.algorithms.leetcode;
/*
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
 */
public class A28_ImplementIndexOf {
    public static void main(String[] args) {
        System.out.println(strStr("ababbbbbba","bb"));
    }
    /*
    其实就是java中的indexOf()方法
     */
    public static int strStr(String haystack, String needle) {
        haystack.indexOf(needle);
        if("".equals(needle))
            return 0;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        int len1=chars1.length;
        int len2=chars2.length;
        if(len1<len2)
            return -1;
        for (int i = 0; i <= len1-len2; i++) {
            int j=0;
            while( j<len2 && chars1[j+i]==chars2[j] ){
                j++;
            }
            if(j==len2)
                return i;
        }
        return -1;
    }
}
