package ljtao.book_study.effective_java.my_code.chapter08.item49;


import java.util.Date;

/**
 * @author ljtao3 on 2020/1/15
 */
public final class Period {
    private final Date start;
    private final Date end;
    public Period(Date start,Date end){
        if(start.compareTo(end)>0){
            throw new IllegalArgumentException(start +" after "+ end);
        }
        /**
         * 如果是用这种的话
         * this.start=start;
         * this.end=end;
         * 外部传入的类，如果修改数据，该不可变量也会被修改到。
         * 就像下面这个传入的例子。
         * Date start = new Date();
         * Date end = new Date();
         * Period p = new Period(start, end);
         * end.setYear(78);
         */
        //防御性拷贝。这样外部传入参数的修改，不会影响到类内部的数据
        this.start=new Date(start.getTime());
        this.end=new Date(end.getTime());
    }
    public Date getStart(){
        //为了抵御第二次攻击，只需修改访问器以返回可变内部字属性的防御性拷贝:
        //return start;
        return new Date(start.getTime());
    }
    public Date getEnd(){
        return new Date(end.getTime());
    }
}
