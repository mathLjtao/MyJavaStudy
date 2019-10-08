package ljtao.pattern.m_proxy.txclass.util;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/*
    通过对需要被代理的对象进行反射，拼接成一段新的程序，然后保存成一个java文件，
    编译成为一个class，
    创建代理对象，然后return回去
     */
public class ProxyUtil {
    public static Object newProxyInstance(Object target) throws Exception{
        String content="";
        String packageContent="package ljtao.pattern.m_proxy.txclass;";
        Class targetInfo=target.getClass().getInterfaces()[0];
        String targetInfoName=targetInfo.getSimpleName();
        String importContent="import "+targetInfo.getName()+";";
        String classContent="public class $Proxy implements "+targetInfoName+"{";
        /*
            private UserDao userDao;
            public  UserLogProxy(UserDao userDao){
                this.userDao=userDao;
            }
         */
        String fieldContent ="private "+targetInfoName+" target;";
        String construterContent="public $Proxy("+targetInfoName+" target){"+
                "this.target=target;}";

        String methodsContent="";
        Method[] declaredMethods = targetInfo.getDeclaredMethods();
        String p;
        //对方法进行处理
        for(Method method:declaredMethods){
            /*
            public void print(String name) {
                System.out.println("log");
                userDao.print(name);
            }
             */
            Class returnType = method.getReturnType();
            String methodName = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            String argsContent="";
            String argsParam="";
            int i=0;
            for(Class<?> parameterType:parameterTypes){
                String simpleName = parameterType.getSimpleName();
                argsContent+=simpleName+" p"+(++i)+",";
                argsParam+=" p"+i+",";
            }
            if(argsContent.length()>0){
                argsContent=argsContent.substring(0,argsContent.lastIndexOf(","));
                argsParam=argsParam.substring(0,argsParam.lastIndexOf(","));
            }
            methodsContent+="public "+returnType.getName()+" "+methodName+"("+argsContent+"){"+
                "System.out.println(\"log....\");"+
                "target."+methodName+"("+argsParam+");}";
        }
        content+=packageContent+importContent+classContent+fieldContent+construterContent+methodsContent+"}";
        File file=new File("D:\\workspaces\\MyJavaStudy\\src\\main\\java\\ljtao\\pattern\\m_proxy\\txclass\\$Proxy.java");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fout=new FileWriter(file);
        fout.write(content);
        fout.flush();
        fout.close();

        //将文件编译成class文件
        JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
        Iterable javaFileObjects = standardFileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        standardFileManager.close();

        URL[] urls= new URL[]{new URL("file:d\\\\")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> aClass = urlClassLoader.loadClass("ljtao.pattern.m_proxy.txclass.$Proxy");
        //通过构造方法创建对象
        Constructor<?> constructor = aClass.getConstructor(targetInfo);
        Object proxy = constructor.newInstance(target);
        return proxy;
    }
}
