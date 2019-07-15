package ljtao.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.

说明：
给定的 n 保证是有效的。
 */
public class A19_remove {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        removeNthFromEnd(head,5);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list=new ArrayList<>();
        ListNode h=head;
        while (h!=null){
            list.add(h);
            h=h.next;
        }
        int len=list.size();
        if (len==n)
            return head.next;
        ListNode parent=list.get(len-n-1);
        System.out.println(parent.val);
        parent.next=parent.next.next;

        return head;
    }
    /*
    网上的解法：利用快慢指针，一个先走，一个后面再一起走
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    static class ListNode {
        int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
