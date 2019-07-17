package ljtao.javase.annotation.ex2;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Persons.class)
public @interface Person{
    String role() default "";
}