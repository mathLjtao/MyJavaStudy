package ljtao.book_study.head_first_design_patterns.b_observable.mycode;

import java.util.HashSet;
import java.util.Set;

public class WeatherData implements Subject {
    private String temperature;
    private String humidity;
    private String pressure;
    private Set<Observer> observerSet;

    public WeatherData(){
        observerSet=new HashSet<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerSet.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observerSet.remove(observer);
    }

    public void  measurementsChanged(String t,String h,String p){
        temperature=t;
        humidity=h;
        pressure=p;
        notifyObserver();
    }
    @Override
    public void notifyObserver() {
        for (Observer o:observerSet){
            o.update(getTemperature(),getHumidity(),getPressure());
        }
    }
    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

}
