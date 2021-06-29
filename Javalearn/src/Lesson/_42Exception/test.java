package Lesson._42Exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        // test1();
        zz();
    }

    public static void test1() {
        System.out.println("111");
        // try {
        // int a = 1 / 0;
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        System.out.println("step2");
    }

    // 常见异常 ArithmeticException: / by Zero
    // 空指针异常 NullPointException
    // 数字格式化异常 NumberFormatException

    public static void zz() {
        String str = "234abc";
        Pattern p = Pattern.compile("^\\d+$"); // 正则表达式
        Matcher m = p.matcher(str);
        if (m.matches()) {
            System.out.println(Integer.parseInt(str));
        } else {
            System.out.println("格式错误");
        }

        // 数组下标越界 ArrayIndexOutOfBoundsException
        // 类型转化异常 ClassCastException

    }

}
