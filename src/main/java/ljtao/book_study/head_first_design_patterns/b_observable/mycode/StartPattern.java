package ljtao.book_study.head_first_design_patterns.b_observable.mycode;

public class StartPattern {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        weatherData.registerObserver(new AvgDome());
        weatherData.registerObserver(new CurrentDome());
        weatherData.measurementsChanged("22","33","44");
    }
}
