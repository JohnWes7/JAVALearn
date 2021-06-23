package Lesson._43Exception2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
    public static void main(String[] args) {
        // test3();
        System.out.println(test4());
    }

    public static void test() {
        FileReader reader = null;
        try {
            reader = new FileReader("resource/test43.txt");
            char c1 = (char) reader.read();
            char c2 = (char) reader.read();
            System.out.println("context: " + c1 + c2);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void test2() {
        DateFormat df = new SimpleDateFormat("y-m-d");
        String str = "2049-10-1";
        try {
            Date d = df.parse(str);
            System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // try-with-resource 可以自动关闭实现了AutoClosable接口的类
    // 其实时一种语法糖，编译器帮我们做了处理，转化成了try-catch-finally
    public static void test3() {
        try (FileReader reader = new FileReader("resource/test43.txt")) {
            char c1 = (char) reader.read();
            char c2 = (char) reader.read();
            System.out.println("context: " + c1 + c2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // test return
    // 当finall块中包含return语句时，Eclipse会给出警告“finally block does not complete
    // normally”，原因分析如下：

    // 1、不管try块、catch块中是否有return语句，finally块都会执行。
    // 2、finally块中的return语句会覆盖前面的return语句（try块、catch块中的return语句），所以如果finally块中有return语句，Eclipse编译器会报警告“finally
    // block does not complete normally”。

    // 3、如果finally块中包含了return语句，即使前面的catch块重新抛出了异常，则调用该方法的语句也不会获得catch块重新抛出的异常，而是会得到finally块的返回值，并且不会捕获异常。
    
    // 结论，应避免在finally块中包含return语句。如果你在前面的语句中包含了return语句或重新抛出了异常，又在finally块中包含了return语句，说明你概念混淆，没有理解finally块的意义。
    public static int test4() {
        int a = 10;

        System.out.println("step1");
        try {
            System.out.println("step2");
            a = 20;

            //return a;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            a = 40;
            System.out.println("step3");

            
        }
        return a;
    }

}
