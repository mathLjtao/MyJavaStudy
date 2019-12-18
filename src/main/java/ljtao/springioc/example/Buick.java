package ljtao.springioc.example;

public class Buick implements Car {
    @Override
    public void start() {
        System.out.println("Buick start");
    }

    @Override
    public void stop() {
        System.out.println("Buick stop");
    }
}
