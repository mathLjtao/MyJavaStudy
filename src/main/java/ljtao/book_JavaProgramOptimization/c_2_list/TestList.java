package ljtao.book_JavaProgramOptimization.c_2_list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		demo1();
	}
	/*
	 * 测试List接口的，ArrayList、LinkedList 插入元素性能
	 * 结论：1、插入尾部 ，两个性能相差不大
	 * 2、插入元素到首部，LinkedList性能好一点。
	 * 3、插入元素 多 的情况 ，用LinkedList
	 * 4、查询多，用ArrayList
	 * 5、删除元素时，两个都需要查找看元素在哪个地方，然后再删除，，情况有多种。（a、ArrayList越靠后删除越快，b、LinkedList越靠中删除越慢，靠两边删除快）。。。这个结论很重要。
	 */
	public static void demo1(){
		List<String> al=new ArrayList<>();
		List<String> ll=new LinkedList<>();
		long sysTime=System.currentTimeMillis();
		//ArrayList,插入元素到集合尾部
		for (int i = 0; i < 2000000; i++) {
			al.add("aaa,");
		}
		System.out.println("方法1："+(System.currentTimeMillis()-sysTime));
		
		sysTime=System.currentTimeMillis();
		//LinkedList,插入元素到集合尾部
		for (int i = 0; i < 2000000; i++) {
			ll.add("aaa,");
		}
		System.out.println("方法2："+(System.currentTimeMillis()-sysTime));
		
		List<String> al2=new ArrayList<>();
		List<String> ll2=new LinkedList<>();
		sysTime=System.currentTimeMillis();
		//ArrayList,插入元素到集合首部
		for (int i = 0; i < 100000; i++) {
			al2.add(0, "aaa,");
		}
		System.out.println("方法2："+(System.currentTimeMillis()-sysTime));
		
		sysTime=System.currentTimeMillis();
		//LinkedList,插入元素到集合首部
		for (int i = 0; i < 100000; i++) {
			ll2.add(0, "aaa,");
		}
		System.out.println("方法2："+(System.currentTimeMillis()-sysTime));
		
		sysTime=System.currentTimeMillis();
		//ArrayList,查询元素
		for (int i = 0; i < 100000; i++) {
			al2.get(1000);
		}
		System.out.println("方法2："+(System.currentTimeMillis()-sysTime));
		
		sysTime=System.currentTimeMillis();
		//LinkedList,查询元素
		for (int i = 0; i < 100000; i++) {
			ll2.get(1000);
		}
		System.out.println("方法2："+(System.currentTimeMillis()-sysTime));
	}
}
