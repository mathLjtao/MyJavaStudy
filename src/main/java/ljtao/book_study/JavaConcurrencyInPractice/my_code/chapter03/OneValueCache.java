package ljtao.book_study.JavaConcurrencyInPractice.my_code.chapter03;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author ljtao
 * @date 2020/1/30
 *
 * 对结果进行缓存的不可变容器类
 */
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;
    public OneValueCache(BigInteger i,BigInteger[] factors){
        lastNumber=i;
        lastFactors= Arrays.copyOf(factors,factors.length);
    }
    public BigInteger[] getFactors(BigInteger i){
        if(lastNumber==null || !lastNumber.equals(i)){
            return null;
        }else{
            return Arrays.copyOf(lastFactors,lastFactors.length);
        }
    }
}
