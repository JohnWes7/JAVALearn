package Lesson._50Arraylist;

import java.util.ArrayList;
import java.util.List;

public class Testmain {
    public static void main(String[] args) {
        List<String> strlist = new ArrayList<String>();
        strlist.add("da");
        strlist.get(0);

        MyList<String> list = new MyArrayList<String>();
        System.out.println(list);

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add(0,"daa");
        list.set(2, "z");
        
        System.out.println(list.size());
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println();

        list.remove("aa");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.contain("bb"));
        System.out.println(list.contain("daa"));
        System.out.println();

        Object[] arr = list.toArray();
        for (Object string : arr) {
            System.out.println(string);
        }
        System.out.println();

        list.clear();
        System.out.println(list);
        System.out.println();

        
    }
}