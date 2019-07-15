package ljtao.algorithms.leetcode;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 *
 */
class A02_ListNode{
	int val;
	A02_ListNode next;
	A02_ListNode(int x){
		val=x;
	}
}
public class A02_Solution {
	public static void main(String[] args) {
		A02_ListNode l1=new A02_ListNode(2);
		l1.next=new A02_ListNode(5);
		l1.next.next=new A02_ListNode(4);
		A02_ListNode l = addTwoNumbers2(l1,l1);
		System.out.println("...."+l.val);
		while((l=l.next)!=null){
			System.out.println("..."+l.val);
		}
	}
	/*
	 * 官方解法
	 */
	public static A02_ListNode addTwoNumbers2(A02_ListNode l1, A02_ListNode l2){
		A02_ListNode l3=new A02_ListNode(0);
		A02_ListNode rep=l3;
		int val3=0;
		while(l1!=null || l2!=null){
			int val1=(l1!=null)?l1.val:0;
			int val2=(l2!=null)?l2.val:0;
			val3=val3+val1+val2;
			rep.next=new A02_ListNode(val3%10);
			val3=val3/10;
			rep=rep.next;
			l1=(l1!=null)?l1.next:null;
			l2=(l2!=null)?l2.next:null;
		}
		//还要判断最后一个是不是为1
		if(val3>0){
			rep.next=new A02_ListNode(val3);
		}
		return l3.next;
	}
	/*
	 * 这个解法的话，数太大会溢出，如下例
	[9]
	[1,9,9,9,9,9,9,9,9,9]
	输出：
	[8,0,4,5,6,0,0,1,4,1]
	预期：
	[0,0,0,0,0,0,0,0,0,0,1]
	 */
	public static A02_ListNode addTwoNumbers(A02_ListNode l1, A02_ListNode l2) {
		if(l1==null||l2==null){
			return null;
		}
		int sum1=0,bei1=1,sum2=0,bei2=1;
		sum1=sum1+l1.val*bei1;
		while((l1=l1.next)!=null){
			bei1=bei1*10;
			sum1=sum1+l1.val*bei1;
		}
		sum2=sum2+l2.val*bei2;
		while((l2=l2.next)!=null){
			bei2=bei2*10;
			sum2=sum2+l2.val*bei2;
		}
		int c=sum1+sum2;
		if(c<0){
			return null;		
		}
		A02_ListNode l3=new A02_ListNode(c%10);
		A02_ListNode useL=l3;
		c=c/10;
		if(c==0){
			return l3;
		}
		while(c/10!=0){
			useL.next=new A02_ListNode(c%10);
			useL=useL.next;
			c=c/10;
		}
		useL.next=new A02_ListNode(c%10);
		return l3;
    }
	
}

/*
 *  if(l1==null||l2==null){
			return null;
		}
		int sum1=0,bei1=1,sum2=0,bei2=1;
		sum1=sum1+l1.val*bei1;
		while((l1=l1.next)!=null){
			bei1=bei1*10;
			sum1=sum1+l1.val*bei1;
		}
		sum2=sum2+l2.val*bei2;
		while((l2=l2.next)!=null){
			bei2=bei2*10;
			sum2=sum2+l2.val*bei2;
		}
		int c=sum1+sum2;
		if(c<0){
			return null;		
		}
		ListNode l3=new ListNode(c%10);
		ListNode useL=l3;
		c=c/10;
     if(c==0){
			return l3;
		}
		while(c/10!=0){
			useL.next=new ListNode(c%10);
			useL=useL.next;
			c=c/10;
		}
		useL.next=new ListNode(c%10);
		return l3;
 */

