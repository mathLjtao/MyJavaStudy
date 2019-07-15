package ljtao.book_JavaProgramOptimization.c_5_otherskill;

import java.util.Vector;

public class Student implements Cloneable{
	private int id;
	private String name;
	private Vector courses;
	public Student(){
		try {
			Thread.sleep(1000);
			System.out.println("Student Construnctor called");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public Student newInstance(){
		try {
			return (Student)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
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
