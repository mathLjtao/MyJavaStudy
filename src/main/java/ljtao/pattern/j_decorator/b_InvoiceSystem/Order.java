package ljtao.pattern.j_decorator.b_InvoiceSystem;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Vector;

public abstract class Order {
	private OrderLine lnkOrderLine;
	protected String customerName;
	protected Date salesDate;
	protected Vector items=new Vector(10);
	public void print(){
		for (int i = 0; i < items.size(); i++) {
			OrderLine item=(OrderLine)items.get(i);
			item.printLine();
		}
	}
	/**
	 * 客户名的取值方法
	 */
	public String getCustomerName(){
		return customerName;
	}
	//客户名的赋值方法
	public void SetCustomerName(String customerName){
		this.customerName=customerName;
	}
	//销售日期的取值方法
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	
	public void addItem(OrderLine item){
		items.add(item);
	}
	public void remoteItem(OrderLine item){
		items.remove(item);
	}
	//返回总额
	public double getGrandTotal(){
		double amnt=0.0D;
		for (int i=0;i<items.size();i++){
			OrderLine item=(OrderLine) items.get(i);
			amnt+=item.getSubtotal();
		}
		return amnt;
	}
	//工具方法，将金额格式化
	public String formatCurrency(double amnt){
		return NumberFormat.getCurrencyInstance().format(amnt);
		
	}
	
}
