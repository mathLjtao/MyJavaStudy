package ljtao.pattern.j_decorator.b_InvoiceSystem;

public class HeaderDecorator extends OrderDecorator {
	
	public HeaderDecorator(Order anOrder) {
		
		super(anOrder);
		// TODO Auto-generated constructor stub
	}
	//对打印功能的改造
	public void print(){
		this.printHeader();
		super.order.print();
	}
	private void printHeader() {
		// TODO Auto-generated method stub
		System.out.println("\t***\tI N V O I C E\t***");
		System.out.println(" X Y Z Incorporated\n Date of Sale");
		System.out.println(order.getSalesDate());
		System.out.println("=================");
		System.out.println("Item\tUnits\tPrice\tSubtotal");
	}
}
