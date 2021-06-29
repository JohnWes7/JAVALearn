package Lesson._29对象的转型隐式转换;

public class TestPolym {
    public static void main(String[] args) {
        Dog dog = new Dog();
        animalShout(dog);

        Cat cat = new Cat();
        animalShout(cat);

        //对象的转型
        Animal a = new Dog();
        a.shout();
        //强制转换
        Dog a2 = (Dog)a;
        a2.watchDog();
    }

    public static void animalShout(Animal animal) {
        animal.shout();
    }
}

class Animal {
    public void shout() {
        System.out.println("animal.shout");
    }
}

class Cat extends Animal {
    @Override
    public void shout() {
        System.out.println("mio mio");
    }
}

class Dog extends Animal {
    @Override
    public void shout() {
        System.out.println("wan wan");
    }

    public void watchDog() {
        System.out.println("watchDoge");
    }
}
