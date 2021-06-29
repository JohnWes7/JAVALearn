package Lesson._49Generic;

import java.util.List;

// 通配符 ? 上下限限定
public class Test2 {
    public static void main(String[] args) {

    }

    public static <T extends Dog> void test01(T dog) {
        // T 表示某一个具体类
        // ? 表示任意一个类 
    }

    public static void test02(List<? super Dog> list){

    }

}

class Animal {
}

class Dog extends Animal {

}

class Taidi extends Dog {

}
