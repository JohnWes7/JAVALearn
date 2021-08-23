package Lesson.TestClass;

import homework.Section5_518;

@SuppressWarnings("unused")
public class TestInherit {
    public static void main(final String[] args) {
        // 测试import
        Section5_518.image1();

        final Student stu = new Student(15, "johnwest", "Csharp");
        stu.Rest();
        stu.Study();

        System.out.println();
        //判断对象是不是类的实例
        System.out.println(stu instanceof Student);
        System.out.println(stu instanceof Person);

        //final关键字
        //修饰变量，被它修饰的变量不可更改
        //修饰方法，该方法不可以被子类重写，但是可以被重载
        //修饰类，修饰的类不能被继承，比如math和String
        final int max = 100;


    }
}

class Person {

    int id;
    String name;

    public void Rest() {
        System.out.println(this.name + "正在休息");
    }

    // java的构造函数链接是用的this写在里面csharp是 函数（） ：this（） 链接
    public Person(final int id, final String name) {
        this.id = id;
        this.name = name;
    }
}

//Java只有单继承 没有C++的多继承
//接口可以多几次
//如果定义一个类没有extend 夫类是java.lang.Object
class Student extends Person {

    String major;

    public void Study() {
        System.out.println(name + "正在学习");
    }

    public Student(final int id, final String name, final String major) {
        super(id, name);
        this.major = major;
    }

    //java方法的重写要满足三个要求
    //== 方法名，形参列表要一致
    //<= 要求子类方法返回类型必须和父类相同，抛出的异常声明可以小于或等于父类。 
    //>= 访问权限，子类要大于父类
    @Override
    public void Rest() {
        System.out.println(name + "正在用休息时间学习");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}