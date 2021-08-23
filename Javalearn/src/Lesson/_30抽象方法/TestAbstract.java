package Lesson._30抽象方法;

public class TestAbstract {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.shout();
        dog.sleep();

    }
}
/*
 * 有抽象方法的类只能定义成抽象类
 * 抽象类不能实例化，也就是不能new
 * 抽象类可以包含属性，方法，构造方法 但构造方法不能用来new实例 只能用来被子类继承
 * 抽象类只能用来被继承
 * 抽象方法必须被子类实现
 */
abstract class Animal{
    public abstract void shout();

    public void sleep(){
        System.out.println("animal.sleep");
    }
}

class Dog extends Animal{
    @Override
    public void shout() {
        System.out.println("dog shout");
    }
}

class Cat extends Animal{
    @Override
    public void shout() {
        System.out.println("cat shout");
    }
}
