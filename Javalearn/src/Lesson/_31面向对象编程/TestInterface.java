package Lesson._31面向对象编程;

public class TestInterface {
    public static void main(String[] args) {
        Drone drone = new Drone();
        drone.fly();
        drone.Attack();

        IVolant volant = new Drone();
        volant.fly();
    }
}

// 接口不能有字段，只能有属性，通过重写获得字段
interface IVolant {

    int FLY_HEIGHT = 100; // public static final

    void fly(); // public abstract void fly();
}

interface IAttack {
    void Attack();
}

class Drone implements IVolant,IAttack{
    @Override
    public void fly() {
        System.out.println("drone.fly");
    }

    @Override
    public void Attack() {
        System.out.println("drone.attack");
    }
}

