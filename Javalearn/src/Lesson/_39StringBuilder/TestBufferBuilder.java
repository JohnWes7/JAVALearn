package Lesson._39StringBuilder;

//string 不可变字符序列
//stringBuffer和stringBuilder 可变字符序列，方法一模一样
//stringBuffer 线程安全，做线程同步检查，效率较低
//sringBuilder 线程不安全，不做线程同步检查，因此效率较高，建议采用该类
public class TestBufferBuilder {
    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        StringBuilder stringBuilder = new StringBuilder();
        // StringBuffer stringBuffer = new StringBuffer();
        // String str = new String();

        // append 附加
        stringBuilder.append("a");
        stringBuilder.append("b").append("c").append("d");
        System.out.println(stringBuilder);

        // insert 插入
        stringBuilder.insert(0, "DM");
        System.out.println(stringBuilder);

        // delete 删除
        stringBuilder.delete(0, 2);// [0,2) 包头不包尾
        System.out.println(stringBuilder);
        stringBuilder.deleteCharAt(0);
        System.out.println(stringBuilder);

        // 反转
        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

    public static void test2() {
        // 使用String进行字符串的拼接
        String str = "";
        long num1 = Runtime.getRuntime().freeMemory(); // 获取JVM剩余的内存空间，单位是字节
        long time1 = System.currentTimeMillis(); // 获取当前的时间，单位是毫秒

        for (int i = 0; i < 5000; i++) {
            str += i;
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println(str);
        System.out.println("string占用内存: " + (num1 - num2) + " before: " + num1 + " after: " + num2);
        System.out.println("string time: " + (time2 - time1) + " before: " + time1 + " after: " + time2);

        System.out.println("\n=========使用StringBuild完成拼接==========");
        StringBuilder stringBuilder = new StringBuilder();
        num1 = Runtime.getRuntime().freeMemory();
        time1 = System.currentTimeMillis();

        for (int i = 0; i < 5000; i++) {
            stringBuilder.append(i);
        }
        num2 = Runtime.getRuntime().freeMemory();
        time2 = System.currentTimeMillis();
        System.out.println("stringBuilder占用内存: " + (num1 - num2) + " before: " + num1 + " after: " + num2);
        System.out.println("stringBuilder time: " + (time2 - time1) + " before: " + time1 + " after: " + time2);

        System.out.println("\n=========使用StringBuffer==========");
        StringBuffer stringBuffer = new StringBuffer();
        num1 = Runtime.getRuntime().freeMemory();
        time1 = System.currentTimeMillis();

        for (int i = 0; i < 5000; i++) {
            stringBuffer.append(i);
        }
        num2 = Runtime.getRuntime().freeMemory();
        time2 = System.currentTimeMillis();
        System.out.println("stringBuffer占用内存: " + (num1 - num2) + " before: " + num1 + " after: " + num2);
        System.out.println("stringBuffer time: " + (time2 - time1));
    }
}
