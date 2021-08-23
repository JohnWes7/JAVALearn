package Lesson._54HashMap;

import java.util.HashMap;
import java.util.Map;

public class Testmain {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Map<String,String> test = new HashMap<>();

        MyHashMap<String,String> map = new MyHashMap<>();
        map.put("awg", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        map.put("d", "ddd");
        map.put("c", "123");
        map.put("key", "value");
        map.put("www", "web");
        map.put("C#", "Unity");

        System.out.println(map.get("awg"));
        System.out.println(map);
        System.out.println();

        map.remove("d");
        System.out.println(map);

    }
}
