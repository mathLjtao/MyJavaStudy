package ljtao.test;

public class TestDemo {
    public static void main(String[] args) {
        TestDemo td1=new TestDemo();
        TestDemo td2=new TestDemo();
        System.out.println("td1:"+td1);
        System.out.println("td2:"+td2);
        System.out.println("td1.toString():"+td1.toString());
        System.out.println("td2.toString():"+td2.toString());
        System.out.println("td1.hashCode():"+td1.hashCode());
        System.out.println("td2.hashCode():"+td2.hashCode());
    }
}
