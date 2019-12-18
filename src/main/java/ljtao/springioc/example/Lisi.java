package ljtao.springioc.example;

public class Lisi extends HumanWithCar {
    public Lisi(Car car){
        super(car);
    }
    @Override
    public void shopping() {
        car.start();
        System.out.println("lisi shopping");
        car.stop();
    }

    @Override
    public void gohome() {
        car.start();
        System.out.println("lisi go home");
        car.stop();
    }
}
