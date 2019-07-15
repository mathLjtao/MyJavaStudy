package ljtao.pattern.g_strategy;

interface CalPrice{ 
	//返回一个最终的价格
	Double calPrice(Double originalPrice);
}
//正常顾客
class Common implements CalPrice{
	public Double calPrice(Double originalPrice) {
		return originalPrice;
	}
}
class Vip implements CalPrice{
	public Double calPrice(Double originalPrice) {
		return originalPrice*0.8;
	}
}
class SuperVip implements CalPrice{
	public Double calPrice(Double originalPrice) {
		return originalPrice*0.5;
	}
}
class Customer{
	Double totleCount=0D;
	Double count=0D;
	CalPrice calPrice=new Common();//初始化都是普通会员
	Customer(){
		
	}
	public void buy(Double count) {
		this.count=count;
		totleCount+=count;
		//从工厂中获得对象
		calPrice =CalPriceFactory.getCalPrice(this);
		
	}
	Double calLastAmount(){
		//这个地方体现了策略模式
		return calPrice.calPrice(totleCount);
	}
	Double getCount() {
		return count;
	}
	Double getTotleCount() {
		return totleCount;
	}
}
//一个计算付钱的工厂，根据不同需求创建不同的对象，，
class CalPriceFactory {
	public static CalPrice getCalPrice(Customer customer) {
		Double totleCount =customer.getTotleCount();
		if(totleCount>3000) {
			return new SuperVip();
		}
		else if(totleCount>1000) {
			return new Vip();
		}
		else {
			return new Common();
		}
	}
}

public class B_marketClient {
	public static void main(String[] args) {
		Customer customer = new Customer();
        customer.buy(500D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
        customer.buy(1200D);
        System.out.println("客户需要付钱：" + customer.calLastAmount());
	}
}
