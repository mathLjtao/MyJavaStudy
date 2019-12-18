package ljtao.springioc.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IoCController {
    private Map<String,Object> beanMap=new ConcurrentHashMap<>();
    public Object getBean(String beanName){
        return beanMap.get(beanName);
    }
    public void setBean(Class<?> clazz,String beanName,String... paramBeanNames) throws Exception {
        Object[] paramBeanValues=new Object[paramBeanNames.length];
        for (int i = 0; i < paramBeanNames.length; i++) {
            paramBeanValues[i]=beanMap.get(paramBeanNames[i]);
        }
        Constructor<?>[] constructors = clazz.getConstructors();
        //调用构造方法，实例化bean
        Object bean=null;
        for (Constructor constructor:constructors){
            try {
                bean=constructor.newInstance(paramBeanValues);
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
        if(bean==null){
            throw new Exception("找不到合适的构造方法去实例化bean");
        }
        beanMap.put(beanName,bean);
    }
}
