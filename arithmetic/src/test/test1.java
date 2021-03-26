package test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class test1 implements interface3,interface2,interface1{



    public test1() {

    }

    public void test2(){
        test1();
    }
    @Override
    public void fun2() {

    }

    @Override
    public void fun3() {

    }

    @Override
    public void fun4() {

    }

    @Override
    public void fun1() {
        System.out.println(123);
    }

    public final String b ="klsjdflkj";
   static cat a=new cat(23);
    public static cat teset3(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe UNSAFE = (Unsafe) f.get(null);
            //UNSAFE = sun.misc.Unsafe.getUnsafe();
            Field name = a.getClass().getDeclaredField("a");
            long l = UNSAFE.objectFieldOffset(name);
            UNSAFE.putObject(a, l, 5565);
            Class<?> k = test1.class;
            System.out.println(111);
        } catch (Exception e) {
            System.out.println(e);
        }

//        try {
//            System.out.println("1"+a.getA());
//            System.out.println("6"+a.getA());
//
//        } finally {
//            System.out.println("5"+a.getA());
//            a.setA(22);
//            System.out.println("2"+a.getA());
//        }
        return a;
    }

    public static void main(String[] args) {

    }

//    public AtomicInteger inc=new AtomicInteger(0);

    public volatile int inc = 0;
    public void increase() {
//        inc.getAndIncrement();
        inc++;
    }

    public static void f() {
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }
    public static void test(){
        Integer[] test={12323444,2};
        Integer a=test[0];
        test[0]= null;
        System.out.println(a);
        System.out.println(test[0]);
    }
    public static void append(String str){
        str="is a";
    }
    public static StringBuffer append1(StringBuffer str){
        str.append(" is b");
        return str;
    }
    public static  void test3(){
        List<? extends animal> animals = new ArrayList<cat>();
//        animals.add(new cat(1));
        animals.contains("sss");
    }
}
