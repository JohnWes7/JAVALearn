package Lesson._31面向对象编程;

public class Testinterface2 {

}

interface IA {
    void A();
}

interface IB {
    void B();
}

interface IC extends IA, IB {
    void C();
}

class test implements IC {
    @Override
    public void A() {
        System.out.println("test.A");
    }

    @Override
    public void B() {
        System.out.println("test.B");
    }

    @Override
    public void C() {
        System.out.println();
    }
}