package ljtao.algorithms.leetcode;
/*
将两个有序链表合并为一个 "新的有序链表" 并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class A21_MergeTwoSortedLists {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int i){
            val=i;
        }
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(4);

        System.out.println(mergeTwoLists1(l1,l2));
    }
    /*
    网上的做法，递归
    (1,1)->(1,3)->(2,3)->(4,3)->(4,4)->(4,null) -> （结束递归）
      1 -> 1 -> 2 -> 3 -> 4 -> 4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    /*
    自己的做法
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode re;
        ListNode n=l1;
        ListNode p=l2;
        if(n.val>p.val){
            re=new ListNode(p.val);
            p=p.next;
        }
        else{
            re=new ListNode(n.val);
            n=n.next;
        }
        ListNode fre=re;

        while(n!=null || p!=null){

            if(n==null){
                re.next=p;
                break;
            }
            if(p==null){
                re.next=n;
                break;
            }

            if(n.val>p.val){
                re.next=p;
                p=p.next;
            }
            else{
                re.next=n;
                n=n.next;
            }
            re=re.next;
        }
        return fre;
    }

}
