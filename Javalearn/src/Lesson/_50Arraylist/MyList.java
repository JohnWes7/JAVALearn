package Lesson._50Arraylist;

public interface MyList<E> {
    public int size();

    public boolean isEmpty();

    public void add(E e);

    public void add(int index, E e);

    public E get(int index);

    public E set(int index, E e);

    public boolean contain(E e);

    public Object[] toArray();

    public boolean remove(E e);

    public void remove(int index);

    public void clear();
}
