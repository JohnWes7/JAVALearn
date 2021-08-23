package Lesson._52LinkedList;

import Lesson._50Arraylist.MyList;

public class TestMain {
    public static void main(String[] args) {
        MyList<String> list = new MyLinkedList<String>();
        list.add("aa");
        list.add("e");
        list.add("cc");
        list.add(1, "rng");
        list.add("poe");

        System.out.println(list.get(2));
        System.out.println(list);

        list.add(0, "dada");
        System.out.println(list);
        list.remove("poe");
        list.remove(list.size() - 1);
        list.remove(0);
    }
}
