package Lesson._33InnerClass;

public class TestLocalInnerClass {
    public static void main(String[] args) {
        TestLocalInnerClass tlic = new TestLocalInnerClass();
        tlic.show();
    }

    public void show(){
        System.out.println("step1");

        //局部内部类，作用域仅限该方法
        class Inner{
            public void run(){
                System.out.println("inner.run");
            }
        }

        new Inner().run();
    }
}

//4种内部类 内部类 静态内部类 匿名内部类 局部内部类