package ljtao.dataStructure.list;
/**
 * 顺序表的实现
 * @author ljtao3
 *
 */
public class MyList implements IList{
	private Object[] listElem;
	//当前长度
	private int curLen;
	MyList(int maxSize){
		curLen=0;
		//初始化分配maxSize个存储单位
		listElem=new Object[maxSize];
	}
	@Override
	public void clear() {
		curLen=0;
	}
	@Override
	public boolean isEmpty() {
		return curLen==0;
	}
	@Override
	public int size() {
		return curLen;
	}
	@Override
	public Object get(int i) throws Exception {
		if(i<0||i>=curLen)
			throw new Exception("输入位置错误！！");
		return listElem[i];
	}
	@Override
	public void insert(int i, Object o) throws Exception {
		if(i>=listElem.length){
			throw new Exception("插入位置大于表的最大限度！！");
		}
		if(i>curLen || i<0){
			throw new Exception("插入位置不合法！！");
		}
		//后面不需要再加上if判断
		//从后到前，一个一个替代	
		for (int j = curLen-1; j >=i; j--) 
			listElem[j+1]=listElem[j];
		listElem[i]=o;
		curLen++;
	}
	@Override
	public int indexOf(Object o) {
		for (int i = 0; i <curLen; i++) {
			if(listElem[i].equals(o))
				return i;
		}
		return -1;
	}
	@Override
	public void remove(int i) throws Exception {
		if(i>=curLen || i<0){
			throw new Exception("删除位置不合法！！");
		}
		for (int j = i; j < curLen-1; j++) 
			listElem[j]=listElem[j+1];
		
		curLen--;
	}
	@Override
	public void display() {
		for (int i = 0; i <curLen; i++) {
			System.out.print(listElem[i]+" ");
		}
		System.out.println();
	}
	
}
