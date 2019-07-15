package ljtao.dataStructure.list;


public class MyTest {
	public static void main(String[] args) throws Exception {
		demo2();
	}
	//测试自制queue
	public static void demo5() throws Exception{
		//顺序结构的queue
		ArrayQueue aq=new ArrayQueue(4);
		aq.add("i:1");
		aq.add("i:2");
		aq.add("i:3");
		System.out.println(aq.pop());
		System.out.println(aq.pop());
		System.out.println(aq.pop());
		
		System.out.println("-----------");
		//链式结构的queue
		LinkQueue lq=new LinkQueue();
		lq.add("i:1");
		lq.add("i:2");
		lq.add("i:3");
		System.out.println(lq.pop());
		System.out.println(lq.pop());
		System.out.println(lq.pop());
	}
	//测试自制Stack
	public static void demo4()throws Exception{
		MyStack ms=new MyStack();
		ms.push("aaa");
		ms.push("hh");
		ms.push("oo");
//		System.out.println(ms.peek());
//		System.out.println(ms.pop());
		System.out.println("------------");
		ms.display();
	}
	//测试自制双向链表DoubleLink
	public static void demo3() throws Exception{
		DoubleLink dl=new DoubleLink();
		dl.insertFirst("i:1");
		dl.insertFirst("i:2");
		dl.appendLast("i:4");
		dl.insert(3, "i:5");
		dl.display();
		System.out.println("---------");
		dl.deleteFirst();
		dl.remove(2);
		dl.remove(0);
		dl.display();
	}
	//测试自制链表 LinkList
	public static void demo2() throws Exception{
		LinkList ll=new LinkList(3);
		//ll.display();
		ll.insert(2, "insert2");
		ll.insert(2, "insert3");
		ll.display();
		Node a=new Node(6);
		Node b=new Node(7);
		Node c=new Node(8);
		a=b;
		b=c;
		System.out.println(a.data);
	} 
	//测试顺序表  MyList
	public static void demo1() throws Exception{
		MyList ml=new MyList(10);
		ml.insert(0, 30);
		ml.insert(0, 20);
		ml.insert(0, 10);
		ml.insert(3, 80);
		ml.insert(3, 10);
		ml.remove(1);
		ml.display();
	}
}
