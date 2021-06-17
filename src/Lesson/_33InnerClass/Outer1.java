package Lesson._33InnerClass;

//（注意）c#内部类只能直接访问外部类的静态成员若要访问非静态成员则需要实例化外部类

public class Outer1 {
    public static void main(String[] args) {
        // 非静态内部类对象不许寄存在一个外部类对象里
        // 先创建外部类的对象，然后使用外部类对象创建内部类对象
        Outer2.Inner1 inner1 = new Outer2().new Inner1();
        inner1.test1();
    }
}

class Outer2 {
    private int age = 20;

    public void showage() {
        System.out.println("外部类: " + age);
    }

    // 内部类
    // 非静态内部类不能有静态的方法，静态的属性，静态初始化块
    class Inner1 {
        private int id = 15;
        private int age = 28;

        public void test1() {
            System.out.println("innner");
            System.out.println("内部属性: " + age + " " + this.id);
            System.out.println("外部属性.age: " + Outer2.this.age); // 通过：外部类名.this.属性名，访问外部类属性
            Outer2.this.showage();
        }
    }
}
