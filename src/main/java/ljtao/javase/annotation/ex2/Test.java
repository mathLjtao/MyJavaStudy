package ljtao.javase.annotation.ex2;


import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


@TestAnnotation
public class Test {
    @Person(role="artist")
    @Person(role="coder")
    @Person(role="PM")
    @Check(value="ljtao3")
    public String userId;
    public static void main(String[] args) throws Exception{
        demo1();
    }
    //拿出注解的属性值
    public static void demo1() throws Exception{
        Class clazz=Test.class;
        boolean annotationPresent = clazz.isAnnotationPresent(TestAnnotation.class);
        if(annotationPresent){
            TestAnnotation annotation = (TestAnnotation) clazz.getAnnotation(TestAnnotation.class);
            System.out.println("id:"+annotation.id());
            System.out.println("msg:"+annotation.msg());
        }
        Field uf = clazz.getDeclaredField("userId");
        Check checkA = uf.getAnnotation(Check.class);
        System.out.println(checkA.value());
        Annotation[] annotations = uf.getAnnotations();
        Persons personsA = uf.getAnnotation(Persons.class);
        for (Person p:personsA.value()
             ) {
            System.out.println(p);
        }
        for (Annotation a:annotations) {
            Class<? extends Annotation> aClass = a.annotationType();
            System.out.println("userId变量上的注解有："+aClass.getSimpleName());
        }
    }
}
