package Lesson.TestClass;

public class TestClass {
    public static void main(String[] args) {
        Human human = new Human(15, "johnwest");
        System.out.println(human.toString());
    }
}

class Human {

    int id;
    String name;

    public void Rest() {
        System.out.println(this.name + "正在休息");
    }

    public Human(int id) {
        System.out.println("第一构造函数");
        this.id = id;
    }

    // java的构造函数链接是用的this写在里面csharp是 函数（） ：this（） 链接
    public Human(int id, String name) {
        this(id);
        System.out.println("第二构造函数");
        this.name = name;
    }

    @Override
    public String toString() {
        
        return id + "  " + name;
    }
}