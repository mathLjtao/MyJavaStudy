package ljtao.javase.exception;

public class A01_ExceptionExample {
	public static void main(String[] args) throws Exception {
		//fun1("dd");//1、对存在异常的处理方式，继续抛出
		try {
			fun1("abca");//2、对存在异常的处理方式，用try-catch 捕获异常，进行处理
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("finally---");
			// finally 作用范围> return ...
			//try中有return，会等finally执行后再执行try中的return
		}
	}
	public static void fun1(String s) throws Exception{
		String str="abc";
		if(!str.equals(s)){
			throw new Exception("两字符串不相等！");
		}
		else{
			System.out.println("相等");
		}
	}
}
class MyException extends Exception{
	public MyException(){
		super();
	}
	public MyException(String message){
		super(message);
	}
}