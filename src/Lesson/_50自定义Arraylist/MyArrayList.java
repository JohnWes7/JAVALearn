package Lesson._50自定义Arraylist;

public class MyArrayList<E> implements MyList<E> {

    private int size = 0;
    private Object[] elementData;
    private static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void add(E e) {
        if (size >= elementData.length) {
            Object[] newArray = new Object[elementData.length*2];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }

        elementData[size] = e;
        size++;
    }

    @Override
    public void add(int index, E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void get(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void set(int index, E e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean contain(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public E[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(E e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(int index) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

    }

    
}
