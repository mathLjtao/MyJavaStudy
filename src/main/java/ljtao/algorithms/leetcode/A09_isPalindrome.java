package ljtao.algorithms.leetcode;
/*
    判断是不是一个回文数（整数形式的）
 */
public class A09_isPalindrome {

    public static void main(String[] args) {
        //System.out.println(isPalindrome(101));
        ListNode ln=new ListNode(1);
        ln.next=new ListNode(2);
    }


    public static  boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String a="",b="";
        int len=s.length();
        for (int i=len-1;i>=len/2;i--) {
            a=s.substring(len-1-i,len-i);
            b=s.substring(i,i+1);
            if(!b.equals(a))
                return false;
        }

        return true;
    }
    //官方做法
    public boolean IsPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        //原始数字小于反转后的数字时，就意味着我们已经处理了一半位数的数字。
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
