package ljtao.book_JavaProgramOptimization.c_2_list;

public class Student implements Comparable<Student>{
	String name;
	int score;
	public Student(String name,int score){
		this.name=name;
		this.score=score;
	}
	@Override
	public int compareTo(Student o) {
		return this.score-o.score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
}
