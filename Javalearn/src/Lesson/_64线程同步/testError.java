package Lesson._64线程同步;

//线程同步
//同一个资源多个人都想使用的问题
//概念
//多个线程访问同一个对象 并且某些线程还想修改这个对象
//这时我们就需要用到线程同步 现场同步其实就是一种等待机制 多个需要同时访问此对象的线程
//进入此对象的等待池形成队列 等待前面的线程使用完毕后 下一个线程再使用
public class testError {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Account a1 = new Account(100, "iiiii");
        Drawing drawing1 = new Drawing(80, a1, 0);
        Drawing drawing2 = new Drawing(60, a1, 0);
        
        drawing1.start();
        drawing2.start();
    }
}

class Account {
    int money;
    String aname;

    public Account(int money, String aname) {
        this.money = money;
        this.aname = aname;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

}

class Drawing extends Thread {
    int drawingNum; // 取多少钱
    Account account; // 从哪个账户取
    int expenseTotal; // 总共取了多少钱

    public Drawing(int drawingNum, Account account, int expenseTotal) {
        this.drawingNum = drawingNum;
        this.account = account;
        this.expenseTotal = expenseTotal;
    }

    @Override
    public void run() {

        synchronized(account){
            if (account.getMoney() - drawingNum < 0) {
                return;
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.setMoney(account.getMoney() - drawingNum);
            
        }
        
        expenseTotal += drawingNum;
        System.out.println(this.getName() + ",账户余额：" + account.getMoney());
        System.out.println(this.getName() + ",总共取了：" + this.expenseTotal);
    }
}