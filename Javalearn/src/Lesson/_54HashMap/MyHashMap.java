package Lesson._54HashMap;

public class MyHashMap<K, V> implements MyMap<K, V> {

    // 初始数组长度
    private static final int INITIAL_CAPACITY = 2;
    // 元素个数
    private int size;
    // 核心表
    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {

        int index = hashCode2Index(key.hashCode());

        if (table[index] == null) {
            table[index] = new Entry<K, V>(key, value, index, null);
        } else {
            Entry<K, V> entry = table[index];
            Entry<K, V> last = entry;

            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.setValue(value);
                    return;
                }

                last = entry;
                entry = entry.getNext();
            }

            last.setNext(new Entry<K, V>(key, value, index, null));
        }

        size++;
    }

    private int hashCode2Index(int hashCode) {
        // 改为正数
        hashCode = (hashCode < 0) ? -hashCode : hashCode;

        // int index = 1; //最差的算法 退化成了链表
        // int index = hashCode/table.length; //早期jdk算法
        int index = hashCode & (table.length - 1); // 位运算效率较高 产生一个在[0, lenght - 1]之间的数字
        return index;
    }

    @Override
    public V get(K key) {
        int index = hashCode2Index(key.hashCode());

        if (table[index] != null) {
            Entry<K, V> entry = table[index];

            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }

                entry = entry.getNext();
            }
        }

        throw new RuntimeException("没有该键值对");
    }

    @Override
    public boolean containsKey(K key) {
        int index = hashCode2Index(key.hashCode());

        if (table[index] == null) {
            return false;
        } else {
            Entry<K, V> e = table[index];

            while (e != null) {
                if (e.getKey().equals(key)) {
                    return true;
                }
                e = e.getNext();
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : table) {
            if (entry == null) {
                continue;
            }

            while (entry != null) {
                if (entry.getValue().equals(value)) {
                    return true;
                }

                entry = entry.getNext();
            }
        }
        return false;
    }

    @Override
    public void remove(K key) {
        int index = hashCode2Index(key.hashCode());

        if (table[index] == null) {
            throw new RuntimeException("没有该键值对");
        } else {
            Entry<K, V> e = table[index];
            Entry<K, V> pervious = null;

            while (e != null) {
                if (e.getKey().equals(key)) {
                    // 如果是该index的第一个 则把后面所有的往前移 如果只有一个元素则前移的null
                    if (pervious == null) {
                        table[index] = e.getNext();
                    }
                    // 如果不是则把该元素后面的拼接到前面的元素上
                    else {
                        pervious.setNext(e.getNext());
                    }
                    size--;
                    return;
                }

                pervious = e;
                e = e.getNext();
            }
        }

        throw new RuntimeException("没有该键值对");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        table = new Entry[INITIAL_CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for (Entry<K, V> entry : table) {
            if (entry == null) {
                continue;
            }

            stringBuilder.append("{");

            while (entry != null) {
                stringBuilder.append(entry.getKey().toString() + ":" + entry.getValue().toString() + ", ");

                entry = entry.getNext();
            }

            String temp = stringBuilder.substring(stringBuilder.length() - 2, stringBuilder.length());
            if (temp.equals(", ")) {
                stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            }

            stringBuilder.append("}, ");
        }

        String temp = stringBuilder.substring(stringBuilder.length() - 2, stringBuilder.length());
        if (temp.equals(", ")) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}

class Entry<K, V> {

    private K key;
    private V value;
    private int hash;
    private Entry<K, V> next;

    public Entry(K key, V value, int hash, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Entry<K, V> getNext() {
        return next;
    }

    public void setNext(Entry<K, V> next) {
        this.next = next;
    }

}