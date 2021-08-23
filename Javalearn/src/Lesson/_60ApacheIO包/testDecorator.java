package Lesson._60ApacheIO包;

public class testDecorator {
    public static void main(String[] args) {
        Phone phone = new Phone("iphone90");
        phone.show();
        System.out.println("--------装饰后-------");
        Projecter projecter = new Projecter(phone);
        projecter.show();
    }
}

class Phone {
    private String name;

    public Phone(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("name: " + name + " 具备显示功能");
    }
}

class Projecter {
    Phone p;

    public Projecter(Phone p) {
        this.p = p;
    }

    // 装饰器模式
    public void show() {
        p.show();
        System.out.println("具备投影功能");
    }
}
