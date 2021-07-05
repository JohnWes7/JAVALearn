package Lesson._63线程状态优先级;

public class testSleep {
    public static void main(String[] args) {
        // test1();
        // testJoin();
    }

    // 测试线程暂停 sleep(阻塞) yield(就绪状态)
    public static void test1() {
        sleepThread st = new sleepThread();
        st.start();
    }

    // A线程等待B线程 join等待b线程结束再继续
    public static void testJoin() {
        MachineA a = new MachineA(5);
        a.start();
    }
}

class sleepThread extends Thread {
    boolean live = true;

    @Override
    public void run() {
        int i = 0;

        while (i < 10) {
            System.out.println(Thread.currentThread().getName() + ": " + i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLive() {
        return live;
    }
}

class MachineA extends Thread {

    private int num;

    public MachineA(int num) {
        this.num = num;
    }

    @Override
    public void run() {

        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName() + "A加工产品: " + i + " 耗时1s");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("等待B加工" + i);

            // B开始运作
            MachineB b = new MachineB(i);
            try {
                b.start();
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("B执行错误");
                // 结束JVM 0表示正常退出 非0表示非正常结束
                System.exit(1);
            }

            System.out.println(Thread.currentThread().getName() + " A加工" + i + "完成\n");
        }

        System.out.println("全部加工完成");
    }
}

class MachineB extends Thread {
    private int id;

    public MachineB(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " B加工产品: " + id + " 耗时2s");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "B加工" + id + "完成");
    }
}