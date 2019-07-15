package ljtao.pattern.j_decorator.b_InvoiceSystem;

public class FooterDecorator extends OrderDecorator{

	public FooterDecorator(Order order) {
		super(order);
		// TODO Auto-generated constructor stub
	}
	public void print(){
		super.order.print();
		this.printFooter();
	}
	private void printFooter() {
		// TODO Auto-generated method stub
		System.out.println("============");
		System.out.println("Total\t\t\t"+formatCurrency(super.order.getGrandTotal()));
	}
}
