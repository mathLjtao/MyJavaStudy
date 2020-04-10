package ljtao.book_study.java8Action.sourceCode.appd;

import java.util.function.Function;

public class Lambda {
    Function<Object, String> f = obj -> obj.toString();
}
