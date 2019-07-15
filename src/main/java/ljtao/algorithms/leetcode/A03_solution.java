package ljtao.algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
	输入: "pwwkew"
	输出: 3
	解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。 
 */
public class A03_solution {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring2("abqweratyuiocabcbblkjhgf"));
	}
	/**
	 * 滑动窗口
	 * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j) 向右滑动 1 个元素，则它将变为 [i+1, j+1)
	 */
	public static int lengthOfLongestSubstring2(String s){
		Set<Character> set=new HashSet<>();
		int i=0,j=0,n=s.length();
		int maxLen=0;
		while(i<n && j<n){
			if(!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));//通过j向右滑动
				maxLen=Math.max(maxLen, j-i);
			}
			else{
				set.remove(s.charAt(i++));//通过i向右滑动
			}
		}
		System.out.println(s.charAt(1));
		return maxLen;
	}
	/**
	 * 优化的滑动窗口
	 * 如果 s[j] 在 [i, j) 范围内有与 j' 重复的字符，我们不需要逐渐增加 i 。 我们可以直接跳过 [i，j']范围内的所有元素，
	 * 并将 i 变为 j' + 1
	 */
	public static  int lengthOfLongestSubstring3(String s){
		Map<Character,Integer> map=new HashMap<>();
		int ans=0;
		int n=s.length();
		for (int i = 0,j=0; j < n; j++) {
			if(map.containsKey(s.charAt(j))){
				/*
				 * 这里为什么要用Math.max，让i跟之前的i进行比较，目的是取到最后面 “相同字母的位置”，
				 * 如：abba，  判断到a相同，这里如果不比较，就会用到第一个a的位置值，如果有比较就还是会用到b的位置值
				 */
				i=Math.max(s.charAt(j), i);
			}
			ans=Math.max(ans,j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return ans;
	}
	/**
	 * 又是使用暴力破解法，逐个检查
	 */
	public static  int lengthOfLongestSubstring(String s) {
		int len=s.length();
		//System.out.println(check(cA));
		/*
		 * (1 ,n-1)  全部
		 * (1 ,n-2) (2,n-1 ) 逐个减少
		 * (1,n-3) (2,n-2) (3,n-1) 
		 */
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i+1; j++) {
				if(check(s,j,len+j-(i+1))){
					return (len+j-(i+1)-j)+1;
				}
			}
		}
        return 0;
    }
	public static  boolean check(String  s,int a,int b){
		Set<Character> hs=new HashSet<>();
		//System.out.println(s.substring(a,b));
 		for (int i = a; i <= b; i++) {
			if(!hs.add(s.charAt(i))) return false;
		}
 		return true;
	}
}
