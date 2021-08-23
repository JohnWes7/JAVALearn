package Lesson._56HashSet;

import Lesson._54HashMap.MyHashMap;

public class MyHashSet<E> {

    private MyHashMap<E,Object> map;

    public MyHashSet(){
        map = new MyHashMap<E,Object>();
    }

    public int size(){
        return map.size();
    }

    public void add(E e){
        map.put(e, null); // set 的不可重复利用了map里面键对象的不可重复
    }
}
