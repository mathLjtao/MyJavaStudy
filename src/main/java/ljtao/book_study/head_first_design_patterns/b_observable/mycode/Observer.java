package ljtao.book_study.head_first_design_patterns.b_observable.mycode;

public interface Observer {
    public void update(String temperature, String humidity, String pressure);
}
