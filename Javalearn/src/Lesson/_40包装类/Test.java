package Lesson._40包装类;

public class Test {

    // long -> Long int->Integer
    public static void main(String[] args) {
        // testAutoBox();
        // testCache();
        TestMyInteger();
    }

    public static void TestInteger() {
        // 基本数据类型转化成Integer对象
        Integer int1 = Integer.valueOf(15);

        // 包装类对象转成基本数据类型
        int int2 = int1.intValue();
        long long1 = int1.longValue();
        System.out.println(int2 + " " + long1);

        // 字符串转成Integer对象
        Integer int3 = Integer.parseInt("324");
        System.out.println(int3);

        System.out.println("MAX_VALUE = 0x7fffffff : " + Integer.MAX_VALUE);

    }

    public static void testAutoBox() {
        Integer a = 100; // 自动装箱，编译器自动添加 Integer a = Integer.valueOf(100);
        int b = a; // 自动拆箱 int b = a.intValue();
        System.out.println(b);

        // 空指针异常
        // Integer c = null;
        // int d = c;
    }

    public static void testCache() {
        // 整型 char对应的包装类 在自动装箱时，对于-128~127之间的值会进行缓存的处理，为了提高效率
        // Integer a = new Integer(100); 过时的方法
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        System.out.println(a == b); // a和b时同一个对象

        Integer c = 300;
        Integer d = 300;
        System.out.println(c == d); // false
    }

    public static void TestMyInteger() {
        MyInteger a = MyInteger.valueOf(100);
        MyInteger b = MyInteger.valueOf(100);

        MyInteger c = MyInteger.valueOf(500);
        MyInteger d = MyInteger.valueOf(500);

        System.out.println(a == b);
        System.out.println(c == d);
    }
}
