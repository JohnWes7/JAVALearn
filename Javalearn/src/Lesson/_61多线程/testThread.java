package Lesson._61多线程;

//程序 
//一个静态的概念 一般对应与操作系统中的一个可执行文件
//比如双击则加载到内存中 开始执行程序 于是产生了进程

//进程
//执行中的程序叫进程 是一个动态的概念 现代操作系统都可以同时启动多个进程
//比如可以一边看视频 一边游戏
//进程    是计算机的程序关于某数据合集上的一次运行活动
//是系统进行资源分配和调度的基本单位 是结构的基础
//每个进程由三个部分组成    cpu data code 每个进程都是独立的
//保有自己的cpu事件，代码和数据
//进程的查看    
//Windows系统Ctrl+Alt+Del 启动任务管理器即可查看所用进程
//Linux系统 ps or top

//线程
//一个进程可以尝试很多个线程 同一个进程的多个线程可以共享此进程的某些资源（代码，数据）
//所以线程又称为轻量级进程（lightweight process）
//1     是能够进行运算的最小单位 它被包含在进程之中 是进程的实际运作单位
//2     一个进程可以拥有多个线程
//3     一个进程的多个线程共享相同的内存单元/内存地址空间
//      可以访问相同的变量和对象 而且他们从同一堆中分配对象并进行通信，数据交换和同步操作
//4     线程的启动，中断，消亡，消耗的资源非常少
//5     每个java程序都有一个主线程 main thread（对应main方法启动）


//1.1: green thread
//1.2之后 全部对应操作系统中的线程

//通过继承Thread类实现多线程
//线程实现步骤
//1 导入java.lang.thread
//2 可以通过创建Thread的实例来创建新的线程
//3 每个线程都是通过某个特定的Thread对象所对应的run()来完成其操作的
//  方法run称为线程体
//4 调用Thread类的start()方法来启动一个线程
public class testThread {
    public static void main(String[] args) {
        thread t1 = new thread();
        t1.start(); //启动线程

        thread t2 = new thread();
        t2.start();
    }
}

class thread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //getName()返回的是线程名字
            System.out.println(this.getName()+":"+i);
        }
    }
}
