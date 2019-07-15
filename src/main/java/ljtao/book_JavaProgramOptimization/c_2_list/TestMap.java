package ljtao.book_JavaProgramOptimization.c_2_list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestMap {
	public static void main(String[] args) {
		demo2();
	}
	//HashMap、LinkedHashMap的比较
	public static void demo1(){
		//32代表初始容量，0.77f代表负载因子。 。  默认是16，0.75f
		HashMap<String,String> hm=new HashMap<>(32,0.77f);
		hm.put("1", "aa");
		hm.put("2", "bb");
		hm.put("3", "cc");
		hm.put("4", "dd");
		for(Map.Entry<String, String> e:hm.entrySet()){
			//插入数据是无序的
			System.out.print(e.getKey()+","+e.getValue()+"  ");
		}
		System.out.println("");
		Map<String,String> lhm=new LinkedHashMap<>(32,0.77f);
		lhm.put("1", "aa");
		lhm.put("2", "bb");
		lhm.put("3", "cc");
		lhm.put("4", "dd");
		for(Map.Entry<String, String> e:lhm.entrySet()){
			//排序根据插入数据的顺序
			System.out.print(e.getKey()+","+e.getValue()+"  ");
		}
		
		System.out.println("");
		Map<String,String> tm=new TreeMap<>();
		tm.put("1", "aa");
		tm.put("2", "bb");
		tm.put("5", "cc");
		tm.put("4", "dd");
		for(Map.Entry<String, String> e:tm.entrySet()){
			//基于元素的固有顺序来排序的（由Comparator 或者 comparable确定）
			System.out.print(e.getKey()+","+e.getValue()+"  ");
		}
		
	}
	/*
	 * 自定义TreeMap的排序方式
	 */
	public static void demo2(){
		Map<Student,String> tm=new TreeMap<>();
		Student s1=new Student("Bi",70);
		Student s2=new Student("Da",85);
		Student s3=new Student("Ki",92);
		Student s4=new Student("Ci",68);
		Student s5=new Student("Oi",30);
		tm.put(s1,s1.toString());
		tm.put(s2,s2.toString());
		tm.put(s3,s3.toString());
		tm.put(s4,s4.toString());
		tm.put(s5,s5.toString());
		for(Map.Entry<Student,String> e:tm.entrySet()){
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		//成绩在s5跟s2之间的
		System.out.println("--成绩在Oi跟Da之间的--");
		Map<Student,String> tm1 = ((TreeMap)tm).subMap(s5, s2);
		for(Map.Entry<Student,String> e:tm1.entrySet()){
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		//成绩低于s5的
		System.out.println("--成绩低于Oi的--");
		Map<Student,String> tm2 =((TreeMap)tm).headMap(s5);
		for(Map.Entry<Student,String> e:tm2.entrySet()){
			System.out.println(e.getKey()+"  "+e.getValue());
		}
		//成绩高于s2的
		System.out.println("--成绩高于Da的--");
		Map<Student,String> tm3 =((TreeMap)tm).tailMap(s2);
		for(Map.Entry<Student,String> e:tm3.entrySet()){
			System.out.println(e.getKey()+"  "+e.getValue());
		}
	}
}
