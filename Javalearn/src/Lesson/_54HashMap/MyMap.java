package Lesson._54HashMap;

/**
 * 自定义map接口
 */
public interface MyMap<K, V> {
    public int size();

    public boolean isEmpty();

    public void put(K key, V value);

    public V get(K key);

    public boolean containsKey(K key);

    public boolean containsValue(V value);

    public void remove(K key);

    public void clear();
}
