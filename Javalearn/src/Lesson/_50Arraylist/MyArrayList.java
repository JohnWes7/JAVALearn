package Lesson._50Arraylist;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private int size;
    private Object[] elementData;
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void add(E e) {
        //扩容
        ensureCapacity();

        elementData[size] = e;
        size++;
    }

    @Override
    public void add(int index, E e) {
        //检测索引值
        indexCheck(index);

        // 扩容
        ensureCapacity();

        System.arraycopy(elementData, index, elementData, index + 1,size() - index);
        elementData[index] = e;
        size++;
    }

    //索引值检查
    private void indexCheck(int index){
        //越界
        if (index < 0 || index >= size()) {
            throw new RuntimeException("越界");
        }
    }

    //容量检查并扩容
    private void ensureCapacity(){
        // 扩容
        if (size >= elementData.length) {
            Object[] newArray = new Object[elementData.length * 2];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        indexCheck(index);
        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E e) {
        indexCheck(index);
        Object value = elementData[index];
        elementData[index] = e;
        return (E)value;
    }

    @Override
    public boolean contain(E e) {
        for (int i = 0; i < size(); i++) {
            if (elementData[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size());
    }

    @Override
    public boolean remove(E e) {
        for (int i = 0; i < size(); i++) {
            if (elementData[i].equals(e)) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public void remove(int index) {
        indexCheck(index);
        if(index < size() - 1){
            System.arraycopy(elementData, index + 1, elementData, index, size() - index - 1);
        }

        elementData[size()-1] = null;
        size--;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size(); i++) {
            if (elementData[i] == null) {
                stringBuilder.append("null, ");
            }else{
                stringBuilder.append(elementData[i].toString() + ", ");
            }
        }
        
        if (size() != 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
