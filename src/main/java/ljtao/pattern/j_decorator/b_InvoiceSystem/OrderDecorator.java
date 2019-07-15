package ljtao.pattern.j_decorator.b_InvoiceSystem;
/**
 * 抽象装饰角色OrderDecorator
 * @author ljtao3
 *OrderDecorator是依赖于被装饰对象的，他的构造方法首先需要从被装饰对象中提取salesOrder和customerName等性质。
 */
public abstract class OrderDecorator extends Order{
	protected Order order;
	public OrderDecorator (Order order){
		this.order=order;
		this.setSalesDate(order.getSalesDate());
		this.SetCustomerName(order.getCustomerName());
		//this.items=order.items;
	}
	public void print(){
		super.print();
	}
}
