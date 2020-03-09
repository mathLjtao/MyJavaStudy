package ljtao.javase.thread.lock.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 * CAS机制
 * Compare and swap 比较和交换，属于硬件同步原语，处理器提供了基本内存操作的原子性保证。
 * CAS 操作需要输入两个数值，一个旧值A和一个新值B，在操作期间先比较下旧值有没有发生变化。如果没有发生变化，才交换成新值，发生了变化则不交换、
 * Java中的sun.misc.Unsafe类，提供了compareAndSwapInt()和,compareAndSwapLong()等几个方法实现CAS
 * @author ljtao3 on 2020/3/9
 */
public class CasDemo1 {
    private static Unsafe unsafe;//直接操作内存，修改对象，数组内容
    private  int value=0;
    private static long valueOffset;
    static{
        try {
            //反射技术获取Unsafe
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe)theUnsafe.get(null);

            //获取value属性偏移量（用于定位value属性在内存中的具体地址）
            valueOffset=unsafe.objectFieldOffset(CasDemo1.class.getDeclaredField("value"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        //new CasDemo1().fun1();
        //new CasDemo1().fun2();
        //new CasDemo1().fun3();
        new CasDemo1().fun4();
    }
    //测试cas
    public void fun1(){
        int current;
        //CAS +  循环 重试
        //add
        do {
            current=unsafe.getIntVolatile(this,valueOffset);
            System.out.println(current);
        }while (!unsafe.compareAndSwapInt(this,valueOffset,current,current+1));
        System.out.println(current+1);

        AtomicInteger atomicInteger=new AtomicInteger();
        //jdk这个方法的实现，跟上面差不多
        atomicInteger.incrementAndGet();
    }
    //Atomic方式
    public void fun2() throws Exception{
        AtomicLong atomicLong=new AtomicLong();
        for (int i = 0; i < 3; i++) {
            long start=System.currentTimeMillis();

            new Thread(()->{

                while((System.currentTimeMillis()-start)<500){
                    atomicLong.incrementAndGet();
                }

            }).start();
        }
        Thread.sleep(2000);
        System.out.println("AtomicLong:"+atomicLong.get());
    }

    /*
        LongAdder方式，更新的效率比AtomicLong高
        频繁更新但不太频繁读取的汇总统计信息时使用。
     */
    public void fun3() throws Exception {
        LongAdder longAdder=new LongAdder();
        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                Long start =System.currentTimeMillis();
                while(System.currentTimeMillis()-start<500){
                    longAdder.add(1);
                }
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("LongAdder:"+longAdder.sum());

    }
    //LongAdder增强版，处理累加之外，可以自行定义其他计算
    public void fun4() throws Exception {
        LongAccumulator longAccumulator=new LongAccumulator(new LongBinaryOperator() {
            //left为上一个值，right为当前传入的值（longAccumulator.accumulate(fi)）
            @Override
            public long applyAsLong(long left, long right) {
                //选出最大值
                return left>right?left:right;
            }
        },0) ;//起始值为0
        for (int i = 0; i < 10; i++) {
            int fi = i;
            new Thread(()->{
                longAccumulator.accumulate(fi);
            }).start();
        }



        LongAccumulator longAccumulator2=new LongAccumulator(new LongBinaryOperator() {
            @Override
            public long applyAsLong(long left, long right) {
                //计算出总和
                return left+right;
            }
        },0) ;//起始值为0
        for (int i = 0; i < 10; i++) {
            int fi = i;
            new Thread(()->{
                longAccumulator2.accumulate(fi);
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(longAccumulator.longValue());
        System.out.println(longAccumulator2.longValue());

    }
}
