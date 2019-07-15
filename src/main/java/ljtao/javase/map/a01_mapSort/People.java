package ljtao.javase.map.a01_mapSort;

public class People {
	private String name;
	private String score;//成绩
	private String id;//学好
	public People(String name, String score, String id) {
		this.name=name;
		this.score=score;
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", score=" + score + ", id=" + id + "]";
	}
	
}
