package ljtao.pattern.j_decorator.b_InvoiceSystem;

import java.util.Date;

/**
 *  示意性客户端
 *  顾客购买了四个汽车轮胎，一个汽车前侧挡板，然后由系统打印出发票
 * @author ljtao3
 *
 */
public class Client {
	private static Order order;
	public static void main(String[] args) {
		order =new SalesOrder();
		order.setSalesDate(new Date());
		order.SetCustomerName("XYZ ljtao");
		//购买详情
		OrderLine line1=new OrderLine();
		line1.setItemName("汽车轮胎");
		line1.setUnitPrice(154.23);
		line1.setUnits(4);
		OrderLine line2=new OrderLine();
		line2.setItemName("前侧挡板");
		line2.setUnitPrice(300.23);
		line2.setUnits(1);
		//加入订单
		order.addItem(line1);
		order.addItem(line2);
		//对订单进行装饰，如果要用这个的话，就要改下OrderDecorator  打开这个this.items=order.items;
		//order=new FooterDecorator(new HeaderDecorator(order));
		//这里要将order先放到FooterDecorator中，才能显示出总价
		order=new HeaderDecorator(new FooterDecorator(order));
		order.print();
	}
}
