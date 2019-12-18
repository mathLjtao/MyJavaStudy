package ljtao.springioc.example;

public class Zhangsan extends HumanWithCar {
    public Zhangsan(Car car) {
        super(car);
    }

    @Override
    public void shopping() {
        car.start();
        System.out.println("zhangsan go shopping");
        car.stop();
    }

    @Override
    public void gohome() {
        car.start();
        System.out.println("zhangsan go home");
        car.stop();
    }
}
