package ljtao.book_JavaProgramOptimization.c_1_string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * 字符串的 分隔 与 查询
 */
public class TestSplit {
	public static void main(String[] args) {
		demo4();
	}
	//分隔以某个符号分隔字符串的三种方法
	/*
	 * 1.split()方法  ,,(jdk建议使用这个)
	 * 功能比较强大，可以使用正则表达式,如果分隔的字符串较大，效率会没那么快
	 */
	public static void demo1(){
		String str="a;b,c:d`e";
		String[] split = str.split("[;|,|:|`]");
		for(String s:split){
			System.out.println(s);
		}
	}
	/*
	 * 2.StringTokenizer类
	 * 效率会高一些
	 */
	public static void demo2(){
		//String str="a`b`c`d`e";
		String str="a;b,c:d`e";
		StringTokenizer st=new StringTokenizer(str, "[;|,|:|`]");
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
	}
	//3.自己实现的方式
	public static void demo3(){
		String str="a`b`c`d`e";
		String news;
		StringBuffer sb=new StringBuffer();
		int indexOf ;
		while(true){
			indexOf= str.indexOf("`");
			if (indexOf<0){
				sb.append(str);
				break;
			} 
			news=str.substring(0, indexOf);
			str=str.substring(indexOf+1);
			sb.append(news+" ");
			
		}
		System.out.println(sb.toString());
	}
	//查询字符串有某字符的方法，
	public static void demo4(){
		String str=null;
		StringBuffer sb=new StringBuffer();//方法有同步锁
		StringBuilder sbr=new StringBuilder();
		for(int i = 0;i<1000000;i++){
			sb.append(i);
			sb.append(";");
		}
		str=sb.toString();
		long sysTime=System.currentTimeMillis();
		String result="";
		for (int i = 0; i < 3000; i++) {
			//if(str.startsWith("abc"));
			//if(str.endsWith("abc"));
			result=result+"string"+"buffer"+","+"String"+"builder";
		}
		System.out.println("startsWith和endsWith方法："+(System.currentTimeMillis()-sysTime));
		sysTime=System.currentTimeMillis();
		StringBuffer sb1=new StringBuffer();
		int len=str.length();
		for (int i = 0; i < 3000; i++) {
			//if(str.charAt(0)=='a'&&str.charAt(0)=='b'&&str.charAt(0)=='c');
			//if(str.charAt(len-3)=='a'&&str.charAt(len-2)=='b'&&str.charAt(len-1)=='c');
			sb1.append("string");
			sb1.append("buffer");
			sb1.append(",");
			sb1.append("String");
			sb1.append("builder");
			//sb1=new StringBuffer("");
		}
		System.out.println("charAt方法："+(System.currentTimeMillis()-sysTime));
		sysTime=System.currentTimeMillis();
		
	}
}
