package ljtao.algorithms.leetcode;
/*
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321
 示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class A07_ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse3(-2138473134));
		//-2147483648 , 2147483647 
	}
	//网上的做法
	public int reverse4(int x)
	{
	    int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        //如果溢出的话，直接返回0  
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
	//网上的做法
	public static int reverse3(int x) {
        long res = 0;
        res=-431374831;
        while (x != 0) {
            res *= 10;
            res +=  x%10;  //res=res + x%10
            x /= 10;
        }
        return (int)res == res ? (int)res : 0;
	}
	//网上的做法
	public static int reverse2(int x ){
		int rev = 0;
		int pop;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
          //-2147483648 , 2147483647 
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
	}
	//自己的做法
	public static int reverse(int x) {
		char sign =0;
		String s;
		Long l=0l;
		StringBuffer sb=new StringBuffer();
		if (x == Integer.MIN_VALUE)
		{
			return 0;
		}
		else {
			if(x<0){
				sign='-';
				x=-x;
				sb.append(sign);
			}
			s=Integer.toString(x);
			for (int i = s.length()-1; i >-1; i--) {
				sb.append(s.charAt(i));
			}
			
			l=Long.parseLong(sb.toString());
			
			if(l<-Integer.MIN_VALUE || l>Integer.MAX_VALUE)
				return 0;
		}
        return Integer.parseInt(String.valueOf(l));
    }
}
