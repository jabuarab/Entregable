package um.edu.uy.Tads.TreeJope;

import um.edu.uy.Tads.KeyNotFoundException;
import uy.edu.um.prog2.tad.linkedlist.ListaEnlazada2;

public interface MyTree<K extends Comparable<K>, T> {
    T find(K key) throws EmptyTreeException, KeyNotFoundException;

    void insert(K key, T data);

    void delete(K key) throws EmptyTreeException;

    int size();

    int countLeaf(Nodo<K, T> nodo);

    int countCompleteElements(Nodo<K, T> nodo);

    ListaEnlazada2<T> inOrder(Nodo<K, T> nodo);

    ListaEnlazada2<T> preOrder(Nodo<K, T> nodo);

    ListaEnlazada2<T> postOrder(Nodo<K, T> nodo);
}
