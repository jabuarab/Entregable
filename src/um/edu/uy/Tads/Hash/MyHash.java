package um.edu.uy.Tads.Hash;

import um.edu.uy.Tads.KeyNotFoundException;

public interface MyHash<K extends Comparable<K>, T> {

    void put(K key, T data);

    T get(K key) throws KeyNotFoundException;

    boolean contains(K key);

    void remove(K key);
}
