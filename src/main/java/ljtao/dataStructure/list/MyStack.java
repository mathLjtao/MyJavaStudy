package ljtao.dataStructure.list;
import java.lang.reflect.Array;
/**
 * jdk中的Stack是继承Vector，Stack底层是用数组来存出、取入数据，
 *
 */
public class MyStack {
	private static final int DEFAULT_SIZE = 12;
	private Object[] arr;
	private int count=0;
	MyStack(){
		arr=(Object[]) Array.newInstance(Object.class, DEFAULT_SIZE);
	}
	public void push(Object o){
		arr[count++]=o;
	}
	//查看栈顶元素
	public Object peek(){
		return arr[count-1];
	}
	//取出栈顶元素，并删除
	public Object pop(){
		count--;
		return arr[count];
	}
	public int size(){
		return count;
	}
	public boolean isEmpty(){
		return count==0;
	}
	public void display(){
		while(!isEmpty()){
			System.out.println(pop().toString());
		}
		
	}
}
