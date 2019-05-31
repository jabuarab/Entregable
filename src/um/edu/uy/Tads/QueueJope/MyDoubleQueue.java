package uy.edu.um.prog2.tad.queue;

import uy.edu.um.prog2.exceptions.EmptyQueueException;

public class MyDoubleQueue<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size = 0;

    public void enqueueFinal(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        if (isEmpty()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;
        } else {
            ultimo.setPrevio(nuevoNodo);
            nuevoNodo.setSiguiente(ultimo);
            ultimo = nuevoNodo;
            size++;
        }
    }

    public void enqueueFirst(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        if (isEmpty()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;
        } else {
            primero.setSiguiente(nuevoNodo);
            nuevoNodo.setPrevio(primero);
            primero = nuevoNodo;
            size++;
        }
    }

    public void dequeueFinal() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        } else if (size == 1){
            ultimo = null;
            primero = null;
            size--;
        } else{
            ultimo = ultimo.getSiguiente();
            ultimo.getPrevio().setSiguiente(null);
            ultimo.setPrevio(null);
            size--;
        }
    }

    public void dequeueFirst() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        } else if (size == 1){
            primero = null;
            ultimo = null;
            size--;
        } else{
            primero = primero.getPrevio();
            primero.getSiguiente().setPrevio(null);
            primero.setSiguiente(null);
            size--;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        } else {
            return primero.getValue();
        }
    }

    public int getSize() {
        return size;
    }
}
