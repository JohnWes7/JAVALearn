package Lesson._45容器;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        // test02();
        test3();
    }

    // 测试isEmpty,add,remove,contains,toArrays,clear
    // 这些都位于Conllection接口中
    public static void test01() {
        List<Object> list = new ArrayList<Object>();
        // 有序 可重复
        System.out.println(list.isEmpty());
        list.add("johnwest");
        System.out.println(list);
        System.out.println(list.isEmpty());
        list.add("wrx");
        list.add("kkk");

        System.out.println(list);
        System.out.println("list大小: " + list.size());
        System.out.println("是否包含指定元素(wrx): " + list.contains("wrx"));

        list.remove("johnwest");
        System.out.println(list);

        Object[] objects = list.toArray();
        System.out.println("转化成object数组：" + Arrays.toString(objects));

        list.clear();
        System.out.println(list);
    }

    // 测试和索引操作相关的方法
    public static void test02() {
        // list存储的是有序可重复
        List<Object> list = new ArrayList<Object>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list);
        list.add(2, "z");
        System.out.println(list);
        list.set(2, "x");
        System.out.println(list);
        System.out.println(list.get(1));
        list.add("b");
        System.out.println();

        // 从左到右查找
        System.out.println(list.indexOf("B"));
        // 从右往左找
        System.out.println(list.lastIndexOf("b"));
    }

    // 测试两个容器之间的元素
    public static void test3() {
        List<Object> list = new ArrayList<Object>();
        list.add("ads");
        list.add("edd");
        list.add("emp");

        List<Object> list2 = new ArrayList<Object>();
        list2.add("ads");
        list2.add("dd");
        list2.add("bb");

        System.out.println(list.containsAll(list2));
        System.out.println(list);
        list.addAll(list2);
        System.out.println(list);

        // list.removeAll(list2); //删除掉list2和list中都存在的元素
        // System.out.println(list);

        System.out.println();
        System.out.println(list);
        System.out.println(list2);
        list.retainAll(list2);// 取交集
        System.out.println(list);

        list.remove("ads");
        System.out.println(list);
    }

    //arraylist 数组实现 查询效率搞，增删效率低，线程不安全
    //linkedlist 双向链表实现 查询效率低 增删效率高 线程不安全
    //vector 数组实现的list 相关方法都加了同步检查 线程安全 效率低

    //需要线程安全时 用vector
    //不存在线程安全时 并且查询较多用arraylist 一般就用
    //不存在线程安全时 增删较多用 linkedlist
}
