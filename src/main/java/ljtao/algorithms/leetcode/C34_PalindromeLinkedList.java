package ljtao.algorithms.leetcode;

import java.util.Stack;

/*
   请判断一个链表是否为回文链表。
   示例 1: 输入: 1->2  输出: false
   示例 2: 输入: 1->2->2->1 输出: true
    */
public class C34_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode ln=new ListNode(1);
        ln.next=new ListNode(2);
        ln.next.next=new ListNode(1);
        ln.next.next.next=new ListNode(2);
        ln.next.next.next.next=new ListNode(1);
        System.out.println(isPalindrome1(ln));
    }
    /*
        其他解法：
        将链表压入栈中，
        然后一个个对比，只要对比一半就行了
    */
    public static  boolean isPalindrome1(ListNode head) {
        int count=0;
        Stack<Integer> stack=new Stack<>();
        ListNode n=head;
        while (n!=null){
            stack.push(n.val);
            n=n.next;
            count++;
        }
        for (int i = 1; i <=count/2 ; i++) {
            if (head.val!=stack.peek()){
                return false;
            }
            else {
                head=head.next;
                stack.pop();
            }
        }
        return true;
    }
    /*
    这种做法如果链表过长就会出错
     */
    public static  boolean isPalindrome(ListNode head) {
        int a=0;
        int b=0;
        int c=0;
        ListNode next= head;
        while(next!=null){
            a=a*10+next.val;
            c=c*10;
            if(c==0)
                c=1;
            b=c*next.val+b;
            next=next.next;
        }
        if(a==b)
            return true;
        else
            return false;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
