package Lesson._65生产者消费者模式;

//生产者    指得时负责生产数据的模块 可以是方法对象线程进程
//消费者    指负责处理数据的模块 可能是方法对象线程进程
//缓冲区    消费者不能直接使用生产者的数据 他们之间有个缓冲区
//生产者将生产好的数据放入缓冲区 消费者从缓冲区拿到要处理的数据

//线程并发协作 也叫线程通信 通常用于生产者消费者模式 需要使用wait()/notify()/notifyAll()方法

//final void wait()         表示线程一直等待            
//                          线程执行wait()方法的时候，会放当前的锁，然后让出CPU 进入等待状态
//
//void wait(long timeout)   线程等待指定毫秒参数的事件
//final void notify()       唤醒一个处于等待状态的线程
//final void notifyAll()    唤醒一个对象上所有调用wait方法的线程  

//都只能在同步方法或者同步块代码中使用否则会抛出异常

public class testSFM {
    public static void main(String[] args) {
        SyncStack ss = new SyncStack();
        Produce p = new Produce(ss);
        Consumer c =new Consumer(ss);

        c.start();
        p.start();
    }

}

class ManTou {
    int id;

    public ManTou(int id) {
        this.id = id;
    }
}

// 缓冲区 push压栈 pop出栈
class SyncStack {
    int index = 0;
    ManTou[] ms = new ManTou[10];

    public synchronized void push(ManTou mantou) {
        while (index == ms.length) {
            // 如果满了就直接wait 线程会将持有的对象锁释放进入等待状态
            // 这样锁池中的线程就可以竞争对象获得对象锁
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 唤醒当前对象的等待池中的一个线程 进入当前对象锁池
        this.notify();
        ms[index] = mantou;
        index++;
    }

    public synchronized ManTou pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notify();
        index--;
        return ms[index];
    }
}

class Produce extends Thread {
    SyncStack ss;

    public Produce(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("生产馒头: " + i);
            ManTou m = new ManTou(i);

            ss.push(m);
        }
    }
}

class Consumer extends Thread {
    SyncStack ss;

    public Consumer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            ManTou m = ss.pop();
            System.out.println("消费馒头：" + m.id);
        }
    }
}