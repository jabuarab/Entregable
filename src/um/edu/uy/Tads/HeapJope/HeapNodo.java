package Heap;

public class HeapNodo<K extends Comparable<K>, T> {

    private K key;
    private T data;
    private int amount;

    public HeapNodo(K key, T data) {
        this.key = key;
        this.data = data;
        amount = 1;
    }

    public K getKey() { return key; }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void amountPlus() {
        this.amount++;
    }
}