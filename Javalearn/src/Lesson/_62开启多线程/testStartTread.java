package Lesson._62开启多线程;

public class testStartTread {
    public static void main(String[] args) {
        //testImplementsThread();
        //testLambta();
    }

    public static void testImplementsThread(){
        threadIm ti = new threadIm();
        Thread t1 = new Thread(ti);

        t1.start();

        Thread t2 = new Thread(new threadIm());

        t2.start();
    }

    public static void testLambta(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            }
        }).start();

        //这个只适合接口下面只有一个方法的情况
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }).start();
    }
}

// 测试接口开启多线程
class threadIm implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
