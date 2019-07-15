package ljtao.book_JavaProgramOptimization.c_5_otherskill;

import java.util.Vector;

public class People implements Cloneable{
	private int id;
	private String name;
	private Vector courses;
	public People(){
		try {
			Thread.sleep(1000);
			System.out.println("Student Construnctor called");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public People newInstance(){
		try {
			return (People)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	protected  Object clone() throws CloneNotSupportedException{
		People p=(People)super.clone();
		Vector v=new Vector();
		//创建一个新的Vector对象，将原有的v中的数据全部搬进v1中，这样就能实现简单的深拷贝例子。。副本跟正本，改变某个普通对象不会相互影响。
		Vector v1=p.getCourses();
		for(Object o:v1){
			v.add(o);
		}
		p.setCourses(v);	
		return p;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Vector getCourses() {
		return courses;
	}
	public void setCourses(Vector courses) {
		this.courses = courses;
	}
	
}
