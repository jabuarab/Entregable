package Heap;

public interface MyHeap<K extends Comparable<K>, T> {

    void add(K key, T data);

    T removeRoot();

    int getSize();

}
