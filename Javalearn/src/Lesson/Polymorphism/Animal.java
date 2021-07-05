package Lesson.Polymorphism;
/* 多态是同一个方法调用由于对象不同可能会有不同的行为
 * 多态是方法的多态，不是属性的多态属性没有多态
 * 多态的存在有三个必要条件：继承方法重写，父类引用指向子类对象
 * 父类引用指向子类对象后更，用该父类引用调用子类重写的方法，此时多态就出现了
 */

public class Animal {
    public void Shout(){
        System.out.println("Animal.Shout");
    }
}

class Cat extends Animal{
    @Override
    public void Shout() {
        System.out.println("Cat.Shout");
    }
}

class Dog extends Animal{
    @Override
    public void Shout() {
        System.out.println("Dog.Shout");
    }

    public void WatchDoor(){
        System.out.println("Dog.watchDoor");
    }
}

class Bootstrap{
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        AnimalShout(cat);
        AnimalShout(dog);//多态的三个必要条件：继承，方法的重写，父类引用指向子对象

        //对象的转型
        Animal a = new Dog();
        a.Shout();
        //a.WatchDoor;

        //强制转型
        Dog a2 = (Dog)a;
        a2.WatchDoor();

        System.err.println(a.getClass());//显示是狗

        //转换错误类型
        Cat a3 = (Cat)a;//java.lang.ClassCastException: Polymorphism.Dog cannot be cast to Polymorphism.Cat
        a3.Shout();
    }

    public static void AnimalShout(Animal a){
        a.Shout();
    }
}