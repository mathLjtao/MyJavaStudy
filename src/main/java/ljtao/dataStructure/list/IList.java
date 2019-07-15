package ljtao.dataStructure.list;

public interface IList {
	void clear();
	boolean isEmpty();
	int size();
	Object get(int i) throws Exception;
	void insert(int i,Object o) throws Exception;
	int indexOf(Object o);
	void remove(int i) throws Exception;
	void display();
}
