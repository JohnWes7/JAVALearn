package Lesson._33InnerClass;

public class TestStaticInnerclass {
    public static void main(String[] args) {
        //通过new 外部类名.内部类名()来创建静态内部类的对象
        Outer.Innner innner = new Outer.Innner();
        innner.test();
    }
}

class Outer {
    private int a = 10;
    private static int b = 20;

    public int getA() {
        return a;
    }

    // 静态内部类
    static class Innner {
        public void test() {
            // System.err.println(a); 静态内部类不能直接访问外部类的普通方法属性
            System.out.println(Outer.b);
        }
    }
}
