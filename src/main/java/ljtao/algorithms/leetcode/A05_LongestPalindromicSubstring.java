package ljtao.algorithms.leetcode;

public class A05_LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("sdaehjheadsfjdsks"));
	}
	/*
	 * 从中间扩散的解法,比较优的解法
	 */
	private int lo, maxLen;
	public String longestPalindrome2(String s) {
		int len = s.length();
		if (len < 2)
			return s;
		
	    for (int i = 0; i < len-1; i++) {
	     	extendPalindrome(s, i, i);  //假设回文长度为奇数，尽量延长回文长度。
	     	extendPalindrome(s, i, i+1); //假设回文长度为偶数
	    }
	    return s.substring(lo, lo + maxLen);
	}

	private void extendPalindrome(String s, int j, int k) {
		//从传进来的数向两边扩散
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLen < k - j - 1) {
			lo = j + 1;
			maxLen = k - j - 1;
		}
	}
	/*
	 * 暴力解法
	 */
	public static  String longestPalindrome(String s) {
		int len=s.length();
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i+1; j++) {
				if(check(s,j,len+j-(i+1))){
					return s.substring(j, len+j-(i+1)+1);
					
				}
			}
		}
        return "";
    }	
	static boolean check(String s,int i,int j){
		while(s.charAt(i)==(s.charAt(j))&&i<j){
			i++;
			j--;
		}
		if(i>=j){
			return true;
		}
		else
			return false;
	}
	
	
}
