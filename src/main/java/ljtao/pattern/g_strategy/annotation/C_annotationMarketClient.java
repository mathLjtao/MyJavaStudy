package ljtao.pattern.g_strategy.annotation;
import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

//有效区间注解，可以给策略添加有效区间的设置
@Target(ElementType.TYPE)//表示只能给类添加该注解
@Retention(RetentionPolicy.RUNTIME)//必须要将注解保留在运行时
@interface TotalValidRegion{
	//让区间只支持整数
	int max() default Integer.MAX_VALUE;
	int min() default Integer.MIN_VALUE;
}
interface CalPrice{ 
	//返回一个最终的价格
	Double calPrice(Double originalPrice);
}
@TotalValidRegion(max=1000)//设置普通的在0-1000生效，以下类似，不再注释
class Common implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }

}
@TotalValidRegion(min=1000,max=2000)
class Vip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.8;
    }

}
@TotalValidRegion(min=2000,max=3000)
class SuperVip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }

}
@TotalValidRegion(min=3000)
class GoldVip implements CalPrice{

    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }

}
class Customer{
	private Double totalAmount = 0D;//客户在本商店消费的总额
    private Double amount = 0D;//客户单次消费金额
    private CalPrice calPrice = new Common();//每个客户都有一个计算价格的策略，初始都是普通计算，即原价
    
    //客户购买商品，就会增加它的总额
    public void buy(Double amount){
        this.amount = amount;
        totalAmount += amount;
        /* 变化点，我们将策略的制定转移给了策略工厂，将这部分责任分离出去 */
        calPrice = CalPriceFactory.getInstance().createCalPrice(this);
    }
    //计算客户最终要付的钱
    public Double calLastAmount(){
        return calPrice.calPrice(amount);
    }
    
    public Double getTotalAmount() {
        return totalAmount;
    }
    
    public Double getAmount() {
        return amount;
    }
}
//我们使用一个标准的简单工厂来改进一下策略模式
class CalPriceFactory {
  
  private static final String CAL_PRICE_PACKAGE = "ljtao.pattern.g_strategy.annotation";//这里是一个常量，表示我们扫描策略的包，
  
  private ClassLoader classLoader = getClass().getClassLoader();//我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器
  
  private List<Class<? extends CalPrice>> calPriceList;//策略列表
  
  //根据客户的总金额产生相应的策略
  public CalPrice createCalPrice(Customer customer){
      //在策略列表查找策略
      for (Class<? extends CalPrice> clazz : calPriceList) {
          TotalValidRegion validRegion = handleAnnotation(clazz);//获取该策略的注解
          //判断金额是否在注解的区间
          if (customer.getTotalAmount() > validRegion.min() && customer.getTotalAmount() < validRegion.max()) {
              try {
                  //是的话我们返回一个当前策略的实例
                  return clazz.newInstance();
              } catch (Exception e) {
                  throw new RuntimeException("策略获得失败");
              } 
          }
      }
      throw new RuntimeException("策略获得失败");
  }
  
  //处理注解，我们传入一个策略类，返回它的注解
  private TotalValidRegion handleAnnotation(Class<? extends CalPrice> clazz){
      Annotation[] annotations = clazz.getDeclaredAnnotations();
      if (annotations == null || annotations.length == 0) {
          return null;
      }
      for (int i = 0; i < annotations.length; i++) {
          if (annotations[i] instanceof TotalValidRegion) {
              return (TotalValidRegion) annotations[i];
          }
      }
      return null;
  }
  
  //单例
  private CalPriceFactory(){
      init();
  }
  
  //在工厂初始化时要初始化策略列表
  private void init(){
      calPriceList = new ArrayList<Class<? extends CalPrice>>();
      File[] resources = getResources();//获取到包下所有的class文件
      Class<CalPrice> calPriceClazz = null;
      try {
          calPriceClazz = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());//使用相同的加载器加载策略接口
      } catch (ClassNotFoundException e1) {
          throw new RuntimeException("未找到策略接口");
      }
      for (int i = 0; i < resources.length; i++) {
          try {
              //载入包下的类
              Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "."+resources[i].getName().replace(".class", ""));
              //判断是否是CalPrice的实现类并且不是CalPrice它本身，满足的话加入到策略列表
              if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                  calPriceList.add((Class<? extends CalPrice>) clazz);
              }
          } catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
      }
  }
  //获取扫描的包下面所有的class文件
  private File[] getResources(){
      try {
          File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
          return file.listFiles(new FileFilter() {
              public boolean accept(File pathname) {
                  if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                      return true;
                  }
                  return false;
              }
          });
      } catch (URISyntaxException e) {
          throw new RuntimeException("未找到策略资源");
      }
  }
  
  public static CalPriceFactory getInstance(){
      return CalPriceFactoryInstance.instance;
  }
  
  private static class CalPriceFactoryInstance{
      
      private static CalPriceFactory instance = new CalPriceFactory();
  }
}
public class C_annotationMarketClient {
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
