package Lesson._52LinkedList;

import Lesson._50Arraylist.MyList;

public class MyLinkedList<E> implements MyList<E> {
    private int size;

    private Node<E> first;
    private Node<E> last;

    public MyLinkedList() {
        size = 0;
        first = null;
        last = null;
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
    public void add(E e) {
        // 给容器增加一个obj节点
        if (this.first == null) {
            Node<E> node = new Node<>(null, e, null);

            this.first = node;
            this.last = node;
        } else {
            Node<E> node = new Node<>(last, e, null); // 向前挂钩
            this.last.setNext(node); // 向后挂钩

            this.last = node;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {

        if (index != size) {
            Node<E> temp = nodeAt(index);
            Node<E> p = temp.getPrevious();
            Node<E> newNode = new Node<E>(p, e, temp); // 新点挂钩
    
            if (p != null) {
                p.setNext(newNode);
            }else{
                first = newNode;
            }
            temp.setPrevious(newNode);
            size++;
        }else{
            add(e);
        }
    }

    //返回指定位置的节点
    private Node<E> nodeAt(int index) {
        indexCheck(index);
        Node<E> tempNode = null;

        if (index < (size >> 1)) {
            tempNode = first;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
        } else {
            tempNode = last;
            for (int i = size - 1; i > index; i--) {
                tempNode = tempNode.getPrevious();
            }
        }

        return tempNode;
    }

    //检查index是否合法
    private void indexCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new RuntimeException("index out of bound 索引越界");
        }
    }

    @Override
    public E get(int index) {
        return nodeAt(index).getElement();
    }

    @Override
    public E set(int index, E e) {
        Node<E> temp = nodeAt(index);
        E etemp = temp.getElement();
        temp.setElement(e);

        return etemp;
    }

    @Override
    public boolean contain(E e) {
        Node<E> temp = first;
        while (temp != null) {
            if (temp.getElement().equals(e)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];

        Node<E> temp = first;
        for (int i = 0; i < size; i++) {
            arr[i] = temp.getElement();
            temp = temp.getNext();
        }

        return arr;
    }

    @Override
    public boolean remove(E e) {
        Node<E> temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.getElement().equals(e)) {
                removeNode(temp);
                size--;
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    @Override
    public void remove(int index) {
        Node<E> temp = nodeAt(index);
        removeNode(temp);

        size--;
    }

    private void removeNode(Node<E> temp) {
        Node<E> p = temp.getPrevious();
        Node<E> n = temp.getNext();

        if (p != null) {
            p.setNext(n);
        } else {
            first = n;
        }
        if (n != null) {
            n.setPrevious(p);
        } else {
            last = p;
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node<E> temp = first;

        stringBuilder.append("[");
        while (temp != null) {
            stringBuilder.append(temp.getElement().toString() + ", ");
            temp = temp.getNext();
        }
        if (size != 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}

class Node<E> {
    private Node<E> previous; // 上一个节点
    private Node<E> next; // 下一个节点

    private E element;

    public Node(Node<E> prev, E element, Node<E> next) {
        this.previous = prev;
        this.next = next;
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }
}