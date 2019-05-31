public class HashNode<K extends Comparable<K>, T> {

    private K key;
    private T data;
    private int state; // Estados: 0 = Ocupado, 1 = Libre

    public HashNode(K key, T data, int state) {
        this.key = key;
        this.data = data;
        this.state = state;
    }

    public HashNode(K key, T data) {
        this.key = key;
        this.data = data;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getState() { return state; }

    public void setState(int state) { this.state = state; }
}
