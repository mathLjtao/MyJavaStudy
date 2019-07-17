package ljtao.javase.annotation.ex2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Persons {
    Person[] value();
}


