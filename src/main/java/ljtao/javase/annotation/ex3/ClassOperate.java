package ljtao.javase.annotation.ex3;

import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.StringMemberValue;

import java.lang.reflect.Field;
/**
 * @author ljtao3 on 2020/3/31
 * 字节码操作类
 */
public class ClassOperate {
    private final static  String CLASS_PATH="ljtao.javase.annotation.ex3.User";
    private final static String TARGET_PATH="D:\\workspaces\\MyJavaStudy\\target\\classes";
    public void doClassOperate() throws Exception {

        //创建CtClass容器
        CtClass ctClass=getCtClass(CLASS_PATH);
        //获取class对象和属性
        Class<?> aClass = Class.forName(CLASS_PATH);

        Field[] fields = aClass.getDeclaredFields();
        MyData annotation = aClass.getAnnotation(MyData.class);
        if(annotation==null){
            return;
        }
        for(Field field:fields){
            String fileName=field.getName();
            //取得返回值类型
            String returnType = getReturnType(field);
            //生成get方法
            makeGetMethod(ctClass,fileName,returnType);
            //生成set方法
            makeSetMethod(ctClass,fileName,returnType);
        }
        //更新class文件
        ctClass.writeFile(TARGET_PATH);
    }

    private void makeGetMethod(CtClass ctClass, String fileName, String returnType) {
        StringBuffer sb=new StringBuffer();
        sb.append("public "+returnType+" get"+toUpperCaseFirstIndex(fileName)+"()" +
                "{ return "+fileName+";}");
        try {
            CtMethod ctMethod = CtMethod.make(sb.toString(), ctClass);
            ctClass.addMethod(ctMethod);
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    private void makeSetMethod(CtClass ctClass, String fileName, String returnType) {
        StringBuffer sb=new StringBuffer();
        sb.append("public void set"+toUpperCaseFirstIndex(fileName)+"("+returnType+" var1 )" +
                "{ "+fileName+"=var1;}");
        try {
            CtMethod ctMethod = CtMethod.make(sb.toString(), ctClass);
            ctClass.addMethod(ctMethod);
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }


    private String getReturnType(Field field){
        if (field==null){
            return "";
        }
        Class<?> type = field.getType();
        return type.getSimpleName();
    }
    public static String toUpperCaseFirstIndex(String fieldName) {
        if (org.apache.commons.lang.StringUtils.isEmpty(fieldName)) {
            return "";
        }
        return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    private CtClass getCtClass(String classPath) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classClassPath = new ClassClassPath(this.getClass());
        pool.insertClassPath(classClassPath);

        CtClass ctClass = pool.get(classPath);
        return ctClass;
    }

}
