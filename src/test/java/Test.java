import java.lang.reflect.Type;

public class Test {
    public static void main(String[] args) {
        fun1();
    }

    public static void fun1(){
        Type genericSuperclass = B.class.getGenericSuperclass();
        System.out.println(genericSuperclass instanceof Class);

        Type genericSuperclass1 = B1.class.getGenericSuperclass();
        System.out.println(genericSuperclass1 instanceof Class);
    }
}
