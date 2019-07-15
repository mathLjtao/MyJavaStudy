package ljtao.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 测试String 跟 new String() 还有String.intern()方法
 * @author ljtao3
 *
 */
public class TestString {
	public static void main(String[] args) throws Exception {
		//demo2();
		TestString ts=new TestString();
		Class<? extends TestString> aClass = ts.getClass();

		ClassLoader classLoader = aClass.getClassLoader();
		System.out.println(classLoader.getClass());
		while(classLoader!=null){
			System.out.println(classLoader);
			classLoader=classLoader.getParent();
		}
		Class<?> aClass1 = Class.forName("java.lang.Integer");
		Object o = aClass1.newInstance();

	}
	//测试String的方法
	public static void demo2(){
		String str="ljtao3";
		String itemValue1="ljtao3";
		String itemValue2="yz1";
		String itemValue3="ljtao";
		String[] split = str.split("`");
		Set<String> hs=new HashSet<>();
		for (int i = 0; i < split.length; i++) {
			hs.add(split[i]);
		}
		System.out.println(hs.contains(itemValue1));
		System.out.println(hs.contains(itemValue3));
	}
	public static void fun1(){
		final String s0="a";
		String s1="ss";
		String s2=new String ("ss");
		String s3=s0+"ss";
		String s4="ass";
		System.out.println(s1==s2);
		s2.intern();
		String s5=new String("ss");
		s5.intern();
		String s6="ss";
		String s7="a";
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		System.out.println(s2==s6);
		System.out.println(s0==s7);
	}
}
