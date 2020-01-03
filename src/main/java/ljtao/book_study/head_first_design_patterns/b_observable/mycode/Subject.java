package ljtao.book_study.head_first_design_patterns.b_observable.mycode;


public interface Subject {
    public void registerObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();

}
