package Lesson._63线程状态优先级;

public class testPriority {
    public static void main(String[] args) {
        testpriority1();
    }

    //获取线程基本星系的方法
    //isAlive   判断是否终止
    //getPriority   获取线程优先级数值
    //setPriority   设置线程的优先级数值
    //setName   给线程一个名字
    //getName   取得线程的名字   
    //currenThread  取得当前正在运行的线程对象 也就是取得自己本身

    //线程的优先级
    //处于就绪状态时 会进入就绪队列 等待JVM来挑选
    //线程的优先级用数字表示 范围从1~10 线程的默认优先级是5
    //注意：优先级只是意味着获得得调度的概率低 并不是绝对先调用优先级高的后调用优先级低的
    public static void testpriority1(){
        myThread mt = new myThread();
        Thread t = new Thread(mt, "线程mt");
        Thread t2 = new Thread(mt, "另一个线程");
        
        t.setPriority(1);
        t.start();
        t2.setPriority(10);
        t2.start();
        
    }
}

class myThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": "+i);
            Thread.yield();
        }
    }
    
}
