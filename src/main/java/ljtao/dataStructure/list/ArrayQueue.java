package ljtao.dataStructure.list;

public class ArrayQueue {
	private Object[] mArr;
	private int count;
	ArrayQueue(int size){
		mArr=new Object[size];
		count=0;
	}
	public void add(Object o){
		if(count>=mArr.length )
			throw new RuntimeException("队列已满，count="+count);
		mArr[count++]=o;
	}
	// 返回“队列顶端元素值”，并删除该“元素”
	public Object pop(){
		if(isEmpty())
			throw new RuntimeException("队列为空");
		Object re=mArr[0];
		count--;
		for (int i = 0; i < count; i++) {
			mArr[i]=mArr[i+1];
		}
		return re;
	}
	//返回队列开头元素
	public Object front(){
		return mArr[0];
	}
	public boolean isEmpty(){
		return count==0?true:false;
	}
	public int size(){
		return count;
	}
}
