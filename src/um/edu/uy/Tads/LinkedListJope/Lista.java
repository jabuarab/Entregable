package uy.edu.um.prog2.tad.linkedlist;

import uy.edu.um.prog2.exceptions.PosicionInvalidaException;

public interface Lista<T> {

    void add(T value);
    void remove(int position) throws PosicionInvalidaException;
    T get(int position) throws PosicionInvalidaException;
    boolean elementoExiste(T value);

}
