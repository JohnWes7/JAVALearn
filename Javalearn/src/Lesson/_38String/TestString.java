package Lesson._38String;

import java.util.Arrays;

public class TestString {
    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        // String类的定义
        String s0 = "abc"; // 凡是字符串常量，都会放到字符串的常量池中
        String s1 = new String("abc"); // 建立了一个新的字符串对象
        String s2 = "abc";
        String s3 = "ABC";

        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
        System.out.println(s0.equals(s1));
        System.out.println(s0.equalsIgnoreCase(s3)); // 忽略大小写
    }

    public static void test2() {
        String s1 = "0123456789,How dare you";
        System.out.println(s1.charAt(4));
        System.out.println(s1.length());

        // 字符串转化成数组
        char[] chars = s1.toCharArray();
        System.out.println(Arrays.toString(chars));

        // 判断是否包含子字符串
        System.out.println(s1.indexOf("are")); // 不包含返回-1
        System.out.println(s1.lastIndexOf("are")); // 从后往前找
        System.out.println(s1.contains("How"));
        System.out.println(s1.startsWith("0123"));// 是否以什么开头
        System.out.println(s1.endsWith("you"));// 是否以什么结尾

        // 截取
        String[] strs = s1.split(",");// 可以传入正则表达式
        System.out.println(Arrays.toString(strs));

    }

    public static void test3(){
        String s1 = "0123456789,How dare you";

        //字符替换
        String s2 = s1.replace(" ", "&");
        System.out.println(s1);
        System.out.println(s2);

        System.out.println();

        s2 = s1.substring(4);
        System.out.println(s2);
        s2 = s1.substring(4,9); // [4,9)
        System.out.println(s2);

        System.out.println();

        //改大小写
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());

        System.out.println();

        //去除首尾空格
        String s3 = " How are you ";
        System.out.println(s3);
        System.out.println(s3.trim());
    }
}
