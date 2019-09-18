package ljtao.pattern.d_factoryMethod;
/*
可以根据类名来创建新对象。
可以根据properties文件来设置。
 */
//一个抽象的创建接口
interface Creator {
	public Light createLight();
}

class CreateBuld implements Creator {
	public Light createLight() {
		return new BuldLight();
	}
}

class CreateTube implements Creator {
	public Light createLight() {
		return new TubeLight();
	}
}
//一个抽象的产品接口
interface Light {
	public void turnon();
	public void turnoff();
}

class TubeLight implements Light {
	public void turnon() {
		System.out.println("tube on");
	}

	public void turnoff() {
		System.out.println("tube off");
	}
}

class BuldLight implements Light {
	public void turnon() {
		System.out.println("buld on");
	}

	public void turnoff() {
		System.out.println("buld off");
	}
}

public class A_SimpleDemo {
	public static void main(String[] args) {
		Creator c1=new CreateTube();
		Light l1 = c1.createLight();
		Creator c2=new CreateBuld();
		Light l2 = c2.createLight();
		l1.turnon();
		l1.turnoff();
		l2.turnon();
		l2.turnoff();
	}
}
