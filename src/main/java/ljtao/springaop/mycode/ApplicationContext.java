package ljtao.springaop.mycode;

import ljtao.springaop.mycode.annotion.Aspect;
import ljtao.springaop.mycode.annotion.PointCut;
import ljtao.springaop.mycode.proxy.AbsMethodAdvance;
import ljtao.springaop.mycode.util.ClassUtil;
import ljtao.springaop.mycode.util.ReflectionUtil;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ljtao3 on 2020/3/6
 */
public class ApplicationContext {
    //存放代理类的集合
    public static ConcurrentHashMap<String,Object> proxyBeanMap=new ConcurrentHashMap<>();
    static {
        initAopBeanMap("ljtao.springaop.mycode.service");
    }
    //初始化容器
    private  static void initAopBeanMap(String basePath) {
        try {
            Set<Class<?>> classSet = ClassUtil.getClassSet(basePath);
            for(Class cls:classSet){
                if (cls.isAnnotationPresent(Aspect.class)){
                    Method[] methods = cls.getMethods();
                    for(Method method:methods){
                        if(method.isAnnotationPresent(PointCut.class)){
                            //找到切点
                            PointCut pointCutAnnotation = (PointCut)method.getAnnotations()[0];
                            String pointCutStr= pointCutAnnotation.value();
                            String[] s = pointCutStr.split("_");
                            String className=s[0];//被代理类名
                            String methodName=s[1];//被代理方法名

                            //生成被代理类对象
                            Object targeObj  = ReflectionUtil.newInstance(className);
                            //根据切面创建代理者
                            AbsMethodAdvance absMethodAdvance = (AbsMethodAdvance)ReflectionUtil.newInstance(cls);
                            //设置代理的方法
                            absMethodAdvance.setProxyMethodName(methodName);
                            Object proxyObject = absMethodAdvance.createProxyObject(targeObj);

                            if(proxyObject!=null){
                                proxyBeanMap.put(targeObj.getClass().getSimpleName().toLowerCase(),proxyObject);
                            }
                        }
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
