package ljtao.javase.io.serializable;

import java.io.Serializable;

public class Student implements Serializable{

	/*serialVersionUID来决定由哪个类来加载存在于文件中的对象 
     * 如果指定serialVersionUID的数值，那就能使得其不再与类的成员变量相关联 
     * 不然你已经把对象保存到数据库，这个时候你再给这个对象新增属性，那么反序列化 
     * 就会报：本地类不匹配的错误，但如果指定serialVersionUID值那就不会报错。 
     */ 
	private static final long serialVersionUID = 1L;
	//成员变量写成static的话是不能被持久化的    
	public static final String countryName="china";
	private String name;    
    private int age;    
    //如果想对非静态的数据也不想序列化，则需要加入关键字    
   transient String sex;   
   /* 提供set和get方法，无参和有参方法*/   
   public Student(String name,int age,String sex){
	   this.name=name;
	   this.age=age;
	   this.sex=sex;
   }
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
