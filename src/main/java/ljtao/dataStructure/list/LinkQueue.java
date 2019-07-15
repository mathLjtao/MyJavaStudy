package ljtao.dataStructure.list;

public class LinkQueue {
	private Node mHead;//链表头
	private int curLen;//长度
	LinkQueue(){
		mHead=new Node();
		curLen=0;
	}
	//将元素加到链尾
	public void add(Object o){
		Node now=new Node(o,null);
		Node hNext=mHead;
		for (int i = 0; i <curLen; i++) {
			hNext=hNext.next;
		}
		hNext.next=now;
		curLen++;
	}
	// 返回“队列顶端节点”的值，从链头开始取值，并删除该“节点”
	public Object pop(){
		if(isEmpty())
			throw new RuntimeException("队列为空");
		Node re=mHead.next;
		mHead.next=re.next;
		curLen--;
		return re.data;
	}
	//返回队列开头元素
	public Object front(){
		return mHead.next.data;
	}
	public boolean isEmpty(){
		return curLen==0?true:false;
	}
	public int size(){
		return curLen;
	}
	
	
	private class Node{
		private Object data;
		private Node next;
		public Node(){
			this(null,null);
		}
		public Node(Object data,Node next){
			this.data=data;
			this.next=next;
		}
	}
}
