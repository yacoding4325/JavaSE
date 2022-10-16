package com.coding.test02;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author yaCoding
 * @create 2022-10-15 上午 10:47
 */

public class Test01 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取字节码信息：
        Class cls = Student.class;
        Constructor[] c1 = cls.getConstructors();
        Class[] interfaces = cls.getInterfaces();
//        Constructor[] interfaces2 = interfaces.
        //通过字节码信息可以获取构造器：
        //getConstructors只能获取当前运行时类的被public修饰的构造器

        for(Constructor c:c1){
            System.out.println(c);
        }
        for (Class constructor :interfaces) {
            System.out.println(constructor);
        }

//        System.out.println(interfaces);
        System.out.println("-------------------");
        //getDeclaredConstructors:获取运行时类的全部修饰符的构造器
        Constructor[] c2 = cls.getDeclaredConstructors();
        for(Constructor c:c2){
            System.out.println(c);
        }
        System.out.println("-------------------");
        //获取指定的构造器：
        //得到空构造器
        Constructor con1 = cls.getConstructor();
        System.out.println(con1);
//        //得到两个参数的有参构造器：
        Constructor con2 = cls.getConstructor(double.class, double.class);
        System.out.println(con2);
//        //得到一个参数的有参构造器：并且是private修饰的
        Constructor con3 = cls.getDeclaredConstructor(int.class);
        System.out.println(con3);
//        //有了构造器以后我就可以创建对象：
        Object o1 = con1.newInstance();
        System.out.println(o1);
        Object o2 = con2.newInstance(180.5, 170.6);
        System.out.println(o2);
    }

}
