package ljtao.javase.set.treeset;

import java.util.Set;
import java.util.TreeSet;

import ljtao.javase.map.a01_mapSort.MapValueComparator;
/**
 * TreeSet 的定义
 * 与HashSet是基于HashMap实现一样，TreeSet同样是基于TreeMap实现的。     
     1）TreeSet类概述
        使用元素的自然顺序对元素进行排序
        或者根据创建 set 时提供的 Comparator 进行排序
        具体取决于使用的构造方法。 
     2）TreeSet是如何保证元素的排序和唯一性的
        底层数据结构是红黑树(红黑树是一种自平衡的二叉树)
     3）如果要对存入对象排序，记住如果是对象一定要实现Comparator 或 Comparable
 *
 */
public class A01_TreeSet {
	public static void main(String[] args){
		Set<Integer> ts=new TreeSet<>();
		ts.add(6);
		ts.add(4);
		ts.add(18);
		ts.add(2);
		ts.add(6);
		for(Integer i:ts){
			System.out.print(i+",");
		}
		demo2();
	}
	//Comparable
	public static void  demo1(){
		Set<People> ts=new TreeSet<>();
		ts.add(new People("ming",21));
		ts.add(new People("hua",19));
		ts.add(new People("xiao",23));
		ts.add(new People("ming",20));
		for(People i:ts){
			System.out.println(i.getName()+","+i.getAge());
		}
	}
	//Comparator
	public static void demo2(){
		TreeSet<ljtao.javase.map.a01_mapSort.People> ts=new TreeSet<>(new MyComparable());
		ts.add(new ljtao.javase.map.a01_mapSort.People("ming","21","b"));
		ts.add(new ljtao.javase.map.a01_mapSort.People("hua","19","d"));
		ts.add(new ljtao.javase.map.a01_mapSort.People("xiao","23","e"));
		ts.add(new ljtao.javase.map.a01_mapSort.People("ming","20","a"));
		for(ljtao.javase.map.a01_mapSort.People i:ts){
			System.out.println(i.getName()+","+i.getScore()+","+i.getId());
		}
	}
}
