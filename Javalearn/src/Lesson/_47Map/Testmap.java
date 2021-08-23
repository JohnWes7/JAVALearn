package Lesson._47Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Testmap {
    public static void main(String[] args) {
        // test01();
        // iterateListSet();
        test03();
    }

    // Map就是用来存储键值对的
    // 所有键对象不能重复 用equals来判断
    // Map接口的实现类有HashMap TreeMap HashTable Properties
    public static void test01() {
        // HashMap 线程不安全效率高 允许key或者value为null
        // HashTable 线程安全 效率低 不允许key或者value为null
        Map<Object, Object> m1 = new HashMap<Object, Object>(); // 可以用hashtable替换

        m1.put(1, "one");
        m1.put(2, "two");
        m1.put(3, "three");

        System.out.println(m1.get(2));
        System.out.println(m1);

        m1.put(2, "er");

        System.out.println(m1.get(2));
        System.out.println(m1);
        System.out.println(m1.size());
        System.out.println(m1.isEmpty()); // false
        System.out.println(m1.containsKey(4)); // false
        System.out.println(m1.containsValue("one")); // true

        m1.remove(1);
        System.out.println(m1); // 移除

        Map<Object, Object> m2 = new HashMap<Object, Object>();
        m2.put("yi", "1111");
        m2.put("er", "2222");
        m2.put(3, "3333");

        m1.putAll(m2);
        System.out.println(m1);
    }

    // 简单泛型
    public static void test02() {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        String str = list.get(0);
        System.out.println(str);

        Set<Integer> set = new HashSet<>();
        set.add(123);

        Map<String, String> map = new HashMap<>();
        map.put("一", "one");
    }

    // 遍历list set
    public static void iterateListSet() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        // for循环遍历 set不能用
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();

        // 增强for循环(foreach)
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println();

        // 使用迭代器 Iterator对象 //判断有没有下一个
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String temp = iterator.next();// 把当前指向的对象返回 并指向下一个
            System.out.println(temp);
        }

        System.out.println("\n测试Set");
        Set<String> set = new HashSet<>();
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        for (String string : set) {
            System.out.println(string);
        }
        System.out.println();

        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            String temp = iterator.next();
            System.out.println(temp);
        }
    }

    // 遍历 map
    public static void test03() {
        Map<String, String> map = new HashMap<>();
        map.put("one", "一");
        map.put("two", "二");
        map.put("three", "三");

        Set<String> set = map.keySet();

        for (String string : set) {
            System.out.println(string + "--" + map.get(string));
        }
        System.out.println();

        Collection<String> values = map.values();
        for (String string : values) {
            System.out.println(string);
        }
        System.out.println();

        // 使用entryset遍历key value
        // Entry就是键值对
        Set<Map.Entry<String, String>> entryset = map.entrySet();

        for (Map.Entry<String, String> entry : entryset) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }
}
