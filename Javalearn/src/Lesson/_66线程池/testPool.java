package Lesson._66线程池;

import java.util.concurrent.*;

/*
    通俗来讲，当有工作来，就会向线程池那一个线程当工作完成后
并不是直接关闭线程，而是将这个线程还给线程池供其他任务使用
    这样就避免了频繁创建线程，销毁线程。极大的提高了响应速度
假如创建线程用的事件为t1，执行任务用的事件为t2，销毁线程用的事件为t3，
那么使用线程池就免去了t1和t3的时间
*/

/**
 * 线程池的优势 1解耦作用 线程的创建执行完全分开，方便维护 2重复使用 降低系统资源的消耗 通过重用已存在的线程 降低线程创建和销毁造成的消耗
 * 3统一管理线程 控制线程并发数量，降低服务器压力，统一管理所有线程 4提升系统响应速度 使用线程池以后，工作效率通常能提高10倍以上
 * 
 * handler的拒绝策略 AbortPolicy 不执行新任务 直接抛出异常 提示线程池已满 DisCardPolicy 不执行新任务 也不抛出异常
 */

public class testPool {
    public static void main(String[] args) {
        // test01();
        test02();
    }

    public static void test01() {
        // corePoolSize 核心线程池大小
        // maximumPoolSize 线程池中可以容纳的最大线程数量
        // keepAliveTime 非核心线程保留的最长空闲时间
        // unit 计算保留时间的单位
        // workQueue 任务队列，可以存储任务队列中等待被执行，执行得时FIFO原则(先进先出)
        // threadFactory 创建线程对象的工厂
        // handler 线程池已满，拒绝执行策略

        System.out.println("创建池");
        // ThreadPoolExecutor executor = new ThreadPoolExecutor(0, 20, 60L,
        // TimeUnit.SECONDS,
        // new ArrayBlockingQueue<Runnable>(20));
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(20));

        // 测试 加入20个任务
        for (int i = 0; i < 20; i++) {
            MyTask m = new MyTask(i);
            executor.execute(m);
            System.out.println("加入线程m" + i + "\t线程中线程数目：" + executor.getPoolSize() + "\t等待队列数目："
                    + executor.getQueue().size() + "\t执行完的任务数：" + executor.getCompletedTaskCount());
        }
    }

    public static void test02() {
        ExecutorService es = Executors.newScheduledThreadPool(5);

        // 测试 加入20个任务
        for (int i = 0; i < 20; i++) {
            MyTask m = new MyTask(i);
            es.execute(m);
        }

    }
}

// CachedThreadPool(全是临时工)
// SecudleThreadPool（有临时工也有正式工）
// SingleThreadPool（只有一个正式工）
// FixedThreadPool（全是正式工）

class MyTask implements Runnable {

    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行任务: " + taskNum);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕：" + taskNum);
    }

}
