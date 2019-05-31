package uy.edu.um.prog2.tad.stack;

import java.util.EmptyStackException;

public class ListaStack<T> implements MyStack<T> {

    private Nodo<T> top;
    private int size = 0;

    @Override
    public void pop() throws EmptyStackException {
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            Nodo nodoActual = top.getPrevio();
            top = nodoActual;
            size--;
        }
    }

    @Override
    public T top() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    @Override
    public void push(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        if (isEmpty()) {
            top = nuevoNodo;
            top.setSiguiente(top);
            top.setPrevio(null);
            size++;
        } else {
            top.setSiguiente(nuevoNodo);
            nuevoNodo.setPrevio(top);
            top = nuevoNodo;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void makeEmpty() {
        while(size != 0) pop();
    }
    public int getSize() {
        return size;
    }
}
