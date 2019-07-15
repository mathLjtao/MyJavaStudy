package ljtao.dataStructure.list;
/**
 * 双向链表
 * 参考：http://www.cnblogs.com/skywang12345/p/3561803.html#a33
 * @author ljtao3
 * @param <T>
 */
public class DoubleLink {
	//表头
	public DNode mHead;
	//节点个数
	public int mCount;
	private class DNode {
		public DNode prev;
		public DNode next;
		public Object  data;
		public DNode(Object data,DNode prev,DNode next){
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
	}
	public DoubleLink(){
		//创建表头，表头没有存储数据
		mHead=new DNode(null,null,null);
		//这个很关键，一开始时让表头前后指向自己，后面的appendLast方法，当mCount=0时，才不会报错
		mHead.next=mHead.prev=mHead;
		mCount=0;
	}
	public int size(){
		return mCount;
	}
	public boolean isEmpty(){
		return mCount==0;
	}
	//获取节点
	private DNode getNode(int index)  {
		if(index<0||index>=mCount)
			throw new IndexOutOfBoundsException("index:"+index+",size:"+mCount);
		DNode node=mHead;
		//进行判断，如果属于前半部分就正向查询，如果属于后半部分就反向查询
		if(index<(mCount>>1)){
			for (int i = 0; i <= index; i++) 
				node=node.next;
		}
		else{
			for (int i = mCount-1; i >= index; i--) 
				node=node.prev;
		}
		return node;
	}
	//获取节点的值
	public Object get(int index){
		return getNode(index).data;
	}
	public Object getFirst(){
		return mHead.next.data;
	}
	public Object getLast(){
		return mHead.prev.data;
	}
	//将节点插入到第index位置
	public void insert(int index, Object t){
		if(index<0||(index>mCount && index!=0))
			throw new IndexOutOfBoundsException("index:"+index+",size:"+mCount);
		if(index==mCount) {
			appendLast(t);
			return;
		}
		if(index==0 && isEmpty()){
			DNode now0=new DNode(t,mHead,mHead);
			mHead.next=now0;
			mHead.prev=now0;
			mCount++;
			return;
		}
		DNode p=getNode(index).prev;
		DNode n=getNode(index);
		DNode now=new DNode(t,p,n);
		p.next=now;
		n.prev=now;
		mCount++;
	}
	
	public void remove(int index){
		if(index<0||index>=mCount)
			throw new IndexOutOfBoundsException("index:"+index+",size:"+mCount);
		DNode p=getNode(index).prev;
		DNode n=getNode(index).next;
		p.next=n;
		n.prev=p;
		mCount--;
	}
	public void insertFirst(Object t){
		insert(0,t);
	}
	// 将节点追加到链表的末尾
	public void appendLast(Object t){
		DNode now=new DNode(t,mHead.prev,mHead);
		//这里如果列表是空的话，需要另做操作
			mHead.prev.next=now;
			mHead.prev=now;
		
		mCount++;
	}
	public void deleteFirst() throws Exception{
		del(0);
	}
	public void del(int index){
		DNode  now=getNode(index);
		DNode p=now.prev;
		DNode n=now.next;
		p.next=n;
		n.prev=p;
		now=null;
		mCount--;
	}
	public void deleteLast(){
		del(mCount-1);
	}
	public void display(){
		DNode  now=mHead;
		for (int i = 0; i < mCount; i++) {
			now=now.next;
			System.out.println(now.data.toString());
		}
	}
}
