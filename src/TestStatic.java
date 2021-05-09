public class TestStatic {

    int id;

    static String name = "johnwest";
    static String friend = "zw";

    static {
        System.out.println("类被初始化调用！");
        name = "yrj";
        friend = "ljh";
    }

    static void printName() {
        // static方法中不能用非static成员
        // System.out.println(this);
        System.out.println(name + "  " + friend);
    }

    void login() {
        System.out.println(id + " 登录");
    }

    public static void main(String[] args) {
        TestStatic.printName();

        TestStatic ts1 = new TestStatic();
        ts1.id = 5;
        ts1.login();
    }
}