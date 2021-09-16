package ljtao.test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Long l1=100L;
		Long l2=100L;
		if(l1.equals(l2) ){

		}
		fun6();
		Object obj=new Object();
		new ThreadLocal<String>().set("hhh");
	}
	public static void fun6(){
		HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
		//如果缺值了，才会插入
		// objectObjectHashMap.putIfAbsent();
		// objectObjectHashMap.put()
	}
	//测试A、B、C、累加
	public static void fun5() {
		String s="1";
		char ch=s.charAt(0);
		System.out.println(ch);
		System.out.println(ch+1);
		System.out.println();
		char a = (char)(ch+1);
		System.out.println(a);


	}

	//public static native void arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);
	//测试System类中这个方法
	public static void  fun4(){
		String[] str1=new String[]{"a1","b1","c1"};
		String[] str2=new String[]{"a","b","c","d","e","f"};
		System.arraycopy(str1,0,str2,0,str1.length);
		if(str2.length>str1.length){
			str2[str1.length]=null;
		}
		for (int i = 0; i < str2.length; i++) {
			System.out.println(str2[i]);
		}
		System.out.println(str1);
	}
	public static void fun1(){
		List<String> list =new ArrayList<String>();
		Collections.addAll(list, "a","b");
		System.out.println(list);
		System.out.println(7>>1);
	}
	public static void fun2() {
		//1552031777 oa过来的时间戳需要在后面加上3个0
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date(new Long("1553070078000"));
		//Date date=new Date(new Long("1552950001000"));
		System.out.println(sdf.format(1553070078000L));
		Long systime = System.currentTimeMillis();
		Long time= new Long("1553070078000");
		System.out.println(systime/1000-time/1000);
		System.out.println(sdf.format(new Date()));
	}
	/**
	 * 测试通配符上下限
	 */
	public static void fun3(){
		List<? super A2> list= new ArrayList<>();
		list.add(new A2());
		list.add(new A3());


		List<? extends A2> list1=new ArrayList<>();
		//list1.add(new A1());
		//list1.add(new A2());
		//list1.add(new A3());
		Objects.requireNonNull("a");

	}


}

