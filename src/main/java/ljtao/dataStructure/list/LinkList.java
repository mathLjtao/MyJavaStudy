package ljtao.dataStructure.list;
/**
 * 单链表的实现
 * @author ljtao3
 *
 */
public class LinkList implements IList{
	public Node head;//单链表头指针
	public LinkList(){
		head=new Node();//初始化头结点
	}
	//构造一个长度为n的单链表
	public LinkList(int n)throws Exception{
		this();
		create(n);
	}
	private void create(int n) throws Exception{
		Node p=head;
		for (int i = 0; i < n; i++) {
			Node a=new Node("i:"+i);
			p.next=a;
			p=a;
		}                                                                                                
	}
	public void clear() {
		//直接清空表头数据就行
		head.data=null;
		head.next=null;
	}
	public boolean isEmpty() {
		// 判断表头数据
		return head.next==null;
	}
	public int size() {
		int i=0;
		Node p=head;
		while((p=p.next)!=null)
			i++;
		return i;
	}
	public Object get(int i) throws Exception {
		if(i>=size() || i<0)
			return null;
		Node p=head;
		while(i>=0){
			p=p.next;
			i--;
		}
		return p.data;
	}
	public void insert(int i, Object o) throws Exception {
		if(i>size() || i<0)
			throw new Exception("边界超出!!");
		Node p=head;
		//跑到插入位置的前一个节点
		for (int j = 0; j < i; j++) {
			p=p.next;
		}
		Node pos=p.next;
		if(pos==null){
			p.next=new Node(o);
		}
		else{
			p.next=new Node(o);
			p.next.next=pos;
		}
	}
	public int indexOf(Object o) {
		int i=0;
		Node p=head;
		while((p=p.next)!=null){
			if(p.data.equals(o))
				return i;
			i++;
		}
		return -1;
	}
	public void remove(int i) throws Exception {
		if(i>=size() || i<0)
			throw new Exception("边界超出!!");
		Node p=head;
		for (int j = 0; j < i; j++) 
			p=p.next;
		p.next=p.next.next;
	}
	public void display() {
		Node p=head;
		while((p=p.next)!=null){
			System.out.print(p.data+" ");
		}
		System.out.println();
	}
}
