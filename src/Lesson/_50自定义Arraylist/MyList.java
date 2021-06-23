package Lesson._50自定义Arraylist;

public interface MyList<E> {
    public int size();

    public boolean isEmpty();

    public void add(E e);

    public void add(int index, E e);

    public void get(int index);

    public void set(int index, E e);

    public boolean contain(E e);

    public E[] toArray();

    public boolean remove(E e);

    public boolean remove(int index);

    public void clear();
}
