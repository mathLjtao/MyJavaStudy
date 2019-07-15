package ljtao.dataStructure.list;
//节点类
public class Node {
	public Object data;//存放 数据元素的值
	public Node next;//指针域，存放后继节点(后续节点地址)
	public Node(Object data,Node next){
		this.data=data;
		this.next=next;
	}
	public Node(){
		this(null,null);
	}
	public Node(Object data){
		this(data,null);
	}
}
