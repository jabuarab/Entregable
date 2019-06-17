package um.edu.uy.Tads.Hash;

import um.edu.uy.Tads.KeyNotFoundException;

import java.util.ArrayList;

public class OpenHash<K extends Comparable<K>, T> implements MyHash<K, T> {

    private int size;
    private ArrayList<HashNode<K, T>>[] hash;
    private int mod;


    public OpenHash(int size, int mod) {
        this.size = size;
        hash = new ArrayList[size];
        this.mod = mod;
    }

    @Override
    public void put(K key, T data) {

        int pos = hashFun(key);

        if (hash[pos] == null) {

            hash[pos] = new ArrayList<>(10);

            hash[pos].add(new HashNode<>(key, data));

        } else {

            hash[pos].add(new HashNode<>(key, data));

        }
    }

    @Override
    public T get(K key) throws KeyNotFoundException {

        for (HashNode<K, T> node : hash[hashFun(key)])
            if (node.getKey().compareTo(key) == 0) return node.getData();

        throw new KeyNotFoundException();
    }



    @Override
    public boolean contains(K key) {

        for (HashNode<K, T> node : hash[hashFun(key)])
            if (node.getKey().compareTo(key) == 0) return true;

        return false;

    }

    @Override
    public void remove(K key) {

        int pos = hashFun(key);

        int counter = 0;

        for (HashNode<K, T> node : hash[pos]) {

            if (node.getKey().compareTo(key) == 0) {

                hash[pos].remove(counter);

                break;

            }

            counter += 1;

        }
    }

    public int hashFun(K key) {
        return key.hashCode() % mod;
    }

    public ArrayList<HashNode<K, T>>[] getHash() {
        return hash;
    }

    public ArrayList<HashNode<K, T>> getTodos(K key)  {

        ArrayList<HashNode<K, T>> a = hash[hashFun(key)];

        return a;


    }
}
