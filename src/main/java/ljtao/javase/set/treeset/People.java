package ljtao.javase.set.treeset;

public class People implements Comparable<People>{
	private String name;
	private Integer age;
	People(){}
	People(String name,Integer age){
		this.name=name;
		this.age=age;
	}
	@Override
	public int compareTo(People o) {
		
		return o.age-this.age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

	
}
