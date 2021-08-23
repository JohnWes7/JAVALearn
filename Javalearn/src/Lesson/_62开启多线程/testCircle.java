package Lesson._62开启多线程;

//线程状态和生命周期 
//NEW 新生状态
//调用start() -> Runnable 就绪状态 有执行资格无执行权
//CPU给执行权 变为Running运行状态 
//run() 方法结束[推荐]/stop(),join()[不推荐] -> Terminated 死亡状态
//阻塞状态 Blocked

//测试终止线程的典型方法
//
public class testCircle {
    public static void main(String[] args) {
        testThreadCiycle ttc = new testThreadCiycle();
        Thread t1 = new Thread(ttc);//新生状态
        t1.start(); //就绪状态
        
        for (int i = 0; i < 100; i++) {
            System.out.println("主线程: "+i);
        }

        ttc.terminate();
        System.out.println("ttc stop");
    }
}

class testThreadCiycle implements Runnable {

    boolean live = true; // 标记变量

    @Override
    public void run() {
        int i = 0;
        while (live) {
            System.out.println(Thread.currentThread().getName() + ":" + (i++));
        }
    }

    public void terminate() {
        live = false;
    }
}