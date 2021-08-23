package Lesson._65生产者消费者模式;

import java.util.ArrayList;

public class synclist {
    public static void main(String[] args) {
        SyncQueue<String> sq = new SyncQueue<>(5);
        ProduceQueue pq = new ProduceQueue(sq);
        ConsumerQueue cq = new ConsumerQueue(sq);

        cq.start();
        pq.start();

    }

}

class SyncQueue<T> {
    private ArrayList<T> queue;
    private int capacity;

    public SyncQueue(int capacity) {
        queue = new ArrayList<T>();
        this.capacity = capacity;
    }

    public synchronized void inQueue(T t) {
        while (queue.size() >= capacity) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notify();
        queue.add(t);
    }

    public synchronized T deQueue() {
        while (queue.size() <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notify();
        T temp = queue.get(0);
        queue.remove(0);

        return temp;
    }

    public int size() {
        return queue.size();
    }
}

class ProduceQueue extends Thread {
    private SyncQueue<String> sq;

    public ProduceQueue(SyncQueue<String> sq) {
        this.sq = sq;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            sq.inQueue("字符串：" + Integer.toString(i));
            System.out.println("生产字符串：" + Integer.toString(i) + "\t当前队列长度" + sq.size());
        }
    }
}

class ConsumerQueue extends Thread {
    private SyncQueue<String> sq;

    public ConsumerQueue(SyncQueue<String> sq) {
        this.sq = sq;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("消费：" + sq.deQueue() + "\t当前队列长度" + sq.size());
        }
    }
}