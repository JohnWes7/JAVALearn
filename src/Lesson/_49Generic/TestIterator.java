package Lesson._49Generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("bag");
        list.add("bad");

        // System.out.println(list);
        // for (String string : list) {
        //     System.out.println(string);
        //     if (string.startsWith("b")) {
        //         list.remove(string);
        //     }
        // }
        // System.out.println(list);
        

        // System.out.println(list);
        // for (int i = 0; i < list.size();) {
        //     if (list.get(i).startsWith("b")) {
        //         list.remove(i);
        //     }else{
        //         i++;
        //     }
        // }
        // System.out.println(list);

        //迭代器始终指向当前和下一个位置
        for(Iterator<String> iterator = list.iterator(); iterator.hasNext();){
            String temp = iterator.next();
            if (temp.startsWith("b")) {
                iterator.remove();
            }
        }
    }
}
