package Lesson._67ThreadLocal;

public class testThreadLocal {
    // void set(object value) 设置当前线程的局部变量的值

    // public Object get() 返回房前线程所对应的线程局部变量

    // public void remove() 使用完ThreadLocal变量时 要将当前局部变量的值删除 避免因为线程周期长，造成内存泄漏

    // protected Object initialValue()
    // 在线程第一次调用get()或者set(Object)时才执行，并且执行一次，ThreadLocal中缺少实现直接返回null

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        new threadlocal().start();
        new threadlocal().start();
        new threadlocal().start();
    }
}

class threadlocal extends Thread {

    public static ThreadLocal<Integer> seqNum1 = new ThreadLocal<>() {
        @Override
        protected Integer initialValue() {
            // 100 是初始值 每个线程第一个调用set/get方法时都会调用initialValue()
            return Integer.valueOf(100);
        };
    };

    public static Integer integerNum = 100;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            synchronized(integerNum){
                System.out.println(this.getName() + ": \"num: " + seqNum1.get() + "  " + integerNum + "\"");
                integerNum++;
            }
            
            seqNum1.set(seqNum1.get() + 1);
        }
    }
}
