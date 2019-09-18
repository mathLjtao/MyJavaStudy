package ljtao.javase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/*
反射
反射是在程序运行时动态获取类的信息，如成员变量，成员方法，构造方法，注释等。
假如你不知道一个类的内部信息 可以通过反射获取

能获取到的
类的修饰符，名字，注解
构造方法修饰符，名字，参数，声明的异常，注解
方法的修饰符，返回值，名字，参数，异常，注解
成员变量的修饰符，类型，名字，值
方法体内容获取不到
注释获取不到

 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {
        // java中有三种方式获取Class类，对象是对类的实例化，虚拟机中的类是对Class的实例化，Class用来描述某一个类的信息，如有哪些成员变量，构造方法，成员方法等
        // Class cls=String.class;
        // Class cls="".getClass();
        Class<?> cls = Class.forName("java.lang.String");

        // 可以通过反射调用object的方法包括private修饰的方法，获取object的成员变量，包括private修饰的成员变量
        Object object = "hello world";

        System.out.println("开始打印"+cls.getTypeName()+"类的内部信息...");

        // Class中有四种获取成员变量的方法,分别是
        // getFields() 获取定义的public修饰的成员变量，包括父类定义的成员变量
        // getField(String name) 根据成员变量名称获取public修饰的成员变量，包括父类定义的成员变量
        // getDeclaredFields() 获取某一个类定义的所有成员变量信息（不包括父类的成员变量）
        // getDeclaredField(String name) 根据成员变量名称获取某一个类的成员变量信息
        printDeclaredFields(cls, object);

        // Class中有四种获取构造方法信息的方法,分别是
        // cls.getConstructors() 获取定义的public修饰的构造方法，包括父类定义的构造方法
        // cls.getConstructor(Class... parameterTypes)
        // 根据构造方法参数类型获取定义的public修饰的构造方法，包括父类定义的构造方法
        // cls.getDeclaredConstructors() 获取某一个类定义的所有构造方法，不包括父类定义的构造方法
        // cls.getDeclaredConstructor(Class... parameterTypes)
        // 根据构造方法参数类型获取某一个类定义的所有构造方法，不包括父类定义的构造方法
        printConstrucors(cls);

        // Class中有四种获取方法信息的方法,分别是
        // cls.getMethod(String name, Class... parameterTypes)
        // 根据方法名称和参数类型获取定义的public修饰的方法，包括父类定义的方法
        // cls.getMethods() 获取定义的public修饰的方法，包括父类定义的方法
        // cls.getDeclaredMethod(Stringname, Class... parameterTypes)
        // 根据参数名称和参数类型获取某一个类定义的所有方法，不包括父类定义的方法
        // cls.getDeclaredMethods() 获取某一个类定义的所有方法，不包括父类定义的方法
        printMethods(cls);

    }

    /**
     * 打印某一个类定义的所有成员变量信息（不包括父类的成员变量）
     *
     * @param cls
     *            实例化对象对应的的Class
     * @param object
     *            某一个实例化对象
     */
    public static void printDeclaredFields(Class cls, Object object) {
        System.out.println("\n开始打印成员变量信息...");
        // 获取定义的所有成员变量，Field类表示某一个类的成员变量
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            // 修饰符的字符串表示
            String modifyName = Modifier.toString(field.getModifiers());
            // 成员变量名称
            String fildName = field.getName();
            // 使用field.get方法获取成员变量信息，如果成员变量使用private修饰，必须先设置为可访问,否则调用field.get将抛出异常
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(modifyName + " " + fildName + " = " + String.valueOf(value) + ";");
        }
    }

    /**
     * 打印构造方法
     *
     * @param cls
     */
    public static void printConstrucors(Class cls) {

        System.out.println("\n开始打印构造方法信息...");
        // Constructor类表示类的构造方法
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors) {

            // 可以通过cls.newInstance()调用无参构造方式实例化一个对象，不再演示
            // cls.newInstance()
            // 可以通过constructor.newInstance方法实例化一个对象，不再演示
            // constructor.newInstance(Object... initArgs);

            StringBuilder stringBuilder = new StringBuilder();
            // 访问权限修饰符
            String modifierName = Modifier.toString(constructor.getModifiers());
            if (modifierName != null && modifierName.length() > 0) {
                stringBuilder.append(modifierName + " ");
            }
            // 构造方法名称
            String name = constructor.getName();
            stringBuilder.append(name + "(");
            // 构造方法参数列表
            Class[] paramCls = constructor.getParameterTypes();
            if (paramCls != null && paramCls.length > 0) {
                for (int i = 0; i < paramCls.length; i++) {
                    // 获取构造方法参数类型名称
                    String paramType = paramCls[i].getTypeName();
                    if (i > 0) {
                        stringBuilder.append("," + paramType);
                    } else {
                        stringBuilder.append(paramType);
                    }
                }
                stringBuilder.append(") ");
            } else {
                stringBuilder.append(") ");
            }
            // 获取构造方法抛出的异常信息
            Class[] exceptionCls = constructor.getExceptionTypes();
            if (exceptionCls != null && exceptionCls.length > 0) {
                stringBuilder.append("throws ");
                for (int i = 0; i < exceptionCls.length; i++) {
                    String exceptionName = exceptionCls[i].getTypeName();
                    if (i > 0) {
                        stringBuilder.append("," + exceptionName);
                    } else {
                        stringBuilder.append(exceptionName);
                    }
                }
            }
            System.out.println(stringBuilder.toString());
        }

    }

    /**
     * 打印类的方法信息
     *
     * @param cls
     */
    public static void printMethods(Class cls) {
        System.out.println("\n开始打印方法信息...");
        // 获取类定义的所有方法，不包括父类定义的方法
        Method[] methods = cls.getDeclaredMethods();
        if (methods != null) {
            for (Method method : methods) {

                // 可以通过method.invoke方法调用对象的方法，包括private修饰的方法，不再演示
                // method.invoke(Object obj, Objecect... args)

                StringBuilder stringBuilder = new StringBuilder();
                // 访问权限修饰符
                String modifierName = Modifier.toString(method.getModifiers());
                if (modifierName != null && modifierName.length() > 0) {
                    stringBuilder.append(modifierName + " ");
                }
                // 获取返回类型信息
                Class returnCls = method.getReturnType();
                stringBuilder.append(returnCls.getTypeName());
                // 方法名称
                String name = method.getName();
                stringBuilder.append(name + "(");
                // 方法参数列表
                Class[] paramCls = method.getParameterTypes();
                if (paramCls != null && paramCls.length > 0) {
                    for (int i = 0; i < paramCls.length; i++) {
                        // 获取构造方法参数类型名称
                        String paramType = paramCls[i].getTypeName();
                        if (i > 0) {
                            stringBuilder.append("," + paramType);
                        } else {
                            stringBuilder.append(paramType);
                        }
                    }
                    stringBuilder.append(") ");
                } else {
                    stringBuilder.append(") ");
                }
                // 获取方法抛出的异常信息
                Class[] exceptionCls = method.getExceptionTypes();
                if (exceptionCls != null && exceptionCls.length > 0) {
                    stringBuilder.append("throws ");
                    for (int i = 0; i < exceptionCls.length; i++) {
                        String exceptionName = exceptionCls[i].getTypeName();
                        if (i > 0) {
                            stringBuilder.append("," + exceptionName);
                        } else {
                            stringBuilder.append(exceptionName);
                        }
                    }
                }
                System.out.println(stringBuilder.toString());
            }
        }
    }
}