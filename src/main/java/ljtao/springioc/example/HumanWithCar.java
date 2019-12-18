package ljtao.springioc.example;

public abstract class HumanWithCar implements Human{
    protected  Car car;
    public HumanWithCar(Car car){
        this.car=car;
    }
    @Override
    public abstract void shopping() ;

    @Override
    public abstract void gohome() ;
}
