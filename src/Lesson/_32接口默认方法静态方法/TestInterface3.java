package Lesson._32接口默认方法静态方法;

public class TestInterface3 {
    public static void main(String[] args) {
        IDefault a = new TestDefault();
        a.Default();
        a.tsp();

        IDefault.StaticMethod();
        TestDefault.StaticMethod();
    }
}

interface IDefault {
    default void Default() {
        System.out.println("idefault.default");
    }

    default void tsp() {
        System.out.println("tsp");
    }

    public static void StaticMethod() {
        System.out.println("idefault.staticmethod");
    }
}

class TestDefault implements IDefault {
    public static void StaticMethod() {
        System.out.println("testdefault.staticmethod");
    }

    @Override
    public void tsp() {
        System.out.println("testdefault.tsp");
    }
}
