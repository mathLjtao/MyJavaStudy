package ljtao.pattern.j_decorator.b_InvoiceSystem;

import java.text.NumberFormat;

public class OrderLine {
	//产品名子
	private String itemName;
	//单位数量
	private int units;
	//单价
	private double unitPrice;
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void printLine() {
		// TODO Auto-generated method stub
		System.out.println(itemName+"\t"+units+"\t"+formatCurrency(unitPrice)+"\t"
		+formatCurrency(getSubtotal()));
	}

	//小计金额
	public double getSubtotal() {
		// TODO Auto-generated method stub
		return unitPrice*units;
	}
	//将金额格式化
	private String formatCurrency(double subtotal) {
		// TODO Auto-generated method stub
		return NumberFormat.getCurrencyInstance().format(subtotal);
	}
}
