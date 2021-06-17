package Lesson._33InnerClass;

public class TestAnonymousInnerClass {
    public static void main(String[] args) {
        B b  = new B();
        b.test(new A(){
            @Override
            public void run() {
                System.out.println("匿名内部类,run");
            }
        });   
    }
}

class B{
    public void test(A a){
        a.run();
    }
}

interface A{
    void run();
}
