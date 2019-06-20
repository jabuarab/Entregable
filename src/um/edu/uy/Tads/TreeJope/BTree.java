package um.edu.uy.Tads.TreeJope;

import um.edu.uy.Tads.KeyNotFoundException;
import uy.edu.um.prog2.tad.linkedlist.ListaEnlazada2;

public class BTree<K extends Comparable<K>, T> implements MyTree<K, T> {

    private Nodo<K, T> root;
    private ListaEnlazada2<T> preOrderList = new ListaEnlazada2<>();
    private ListaEnlazada2<T> inOrderList = new ListaEnlazada2<>();
    private ListaEnlazada2<T> posOrderList = new ListaEnlazada2<>();


    public BTree() {
        root = null;
    }

    @Override
    public T find(K key) throws EmptyTreeException, KeyNotFoundException {
        T dataNodo;
        if (root == null) {
            throw new EmptyTreeException();
        } else {
            dataNodo = root.find(key);
        }
        return dataNodo;
    }

    @Override
    public void insert(K key, T data) {
        if (root == null) {
            root = new Nodo<>(key, data);
        } else {
            root.add(key, data);
        }
    }

    @Override
    public void delete(K key) throws EmptyTreeException {
        if (root == null) {
            throw new EmptyTreeException();
        } else {
            root.delete(key);
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Nodo<K, T> nodo) {
        int nodeCounting = 1;
        if (nodo.getLeftChild() != null) nodeCounting += size(nodo.getLeftChild());
        if (nodo.getRightChild() != null) nodeCounting += size(nodo.getRightChild());
        return nodeCounting;
    }

    @Override
    public int countLeaf(Nodo<K, T> nodo) {
        int leafCounting = 0;
        if (nodo.isLeaf()) leafCounting++;
        if (nodo.getLeftChild() != null) leafCounting += countLeaf(nodo.getLeftChild());
        if (nodo.getRightChild() != null) leafCounting += countLeaf(nodo.getRightChild());
        return leafCounting;
    }


    @Override
    public int countCompleteElements(Nodo<K, T> nodo) {
        int counter = 0;
        if (nodo.getRightChild() != null && nodo.getLeftChild() != null) counter++;
        if (nodo.getLeftChild() != null) counter += countCompleteElements(nodo.getLeftChild());
        if (nodo.getRightChild() != null) counter += countCompleteElements(nodo.getRightChild());
        return counter;
    }

    @Override
    public ListaEnlazada2<T> inOrder(Nodo<K, T> nodo) {
        if (nodo != null) {
            this.inOrder(nodo.getLeftChild());
            if (!inOrderList.contains(nodo.getData())) inOrderList.add(nodo.getData());
            this.inOrder(nodo.getRightChild());
        }
        return inOrderList;
    }

    @Override
    public ListaEnlazada2<T> preOrder(Nodo<K, T> nodo) {
        if (nodo != null) {
            if (!preOrderList.contains(nodo.getData())) preOrderList.add(nodo.getData());
            this.preOrder(nodo.getLeftChild());
            this.preOrder(nodo.getRightChild());
        }
        return preOrderList;
    }

    @Override
    public ListaEnlazada2<T> postOrder(Nodo<K, T> nodo) {
        if (nodo != null) {
            this.postOrder(nodo.getLeftChild());
            this.postOrder(nodo.getRightChild());
            if (!posOrderList.contains(nodo.getData())) posOrderList.add(nodo.getData());
        }
        return posOrderList;
    }

    public boolean contains(K key) {
        return root.contains(key);
    }

    public Nodo<K, T> getRoot() {
        return root;
    }
}
