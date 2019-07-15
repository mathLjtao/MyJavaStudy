package ljtao.algorithms.leetcode;
/*
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1:
输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:
输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:
L     D     R
E   O E   I I
E C   I H   N
T     S     G

思路：LEETCO是一次循环 （ numRows*2-2）
 */
public class A06_ZigZagConversion {
	public static void main(String[] args) {
		convert2("LEETCODEISHIRING",5);
	}
	public static  String convert(String s, int numRows) {
		int len=s.length();
		if(s==null || len<2 || numRows==1){
			return s;
		}
		int once=numRows*2-2; //一次多少个
		int frequency=len/once;//循环多少次
		StringBuffer sb=new StringBuffer("");
		for (int k = 0; k < numRows; k++) {
			//首尾做单独计算 
			if(k==numRows-1 || k==0){
				for(int j=0;j<=frequency;j++){
					if(j*once+k<len)
						sb.append(s.charAt(j*once+k));
				}
			}
			else{
				for(int j=0;j<=frequency;j++){
					if(j*once+k<len)
						sb.append(s.charAt(j*once+k));
					if((j+1)*once-k<len)
						sb.append(s.charAt((j+1)*once-k));
				}
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	/*
	 * 网上比较简洁的做法
	 */
	public  static String convert2(String s, int numRows) {
        if(numRows == 1) return s;
        int cycle = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<numRows;i++){
        	//这里比较厉害的是在一个for循环里面，用到了j，k两个变化的参数
            for(int j = i,k = cycle - j;j<s.length();j += cycle,k+= cycle){
                sb.append(s.charAt(j));
                if(k < s.length() && k % (cycle/2) != 0) sb.append(s.charAt(k));
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
