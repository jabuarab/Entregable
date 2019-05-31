package uy.edu.um.prog2.tad.queue;

import uy.edu.um.prog2.exceptions.EmptyQueueException;

public class ListaQueue<T> implements MyQueue<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size = 0;

    @Override
    public void enqueue(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        if (this.isEmpty()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            primero.setPrevio(ultimo);
            ultimo.setSiguiente(primero);
            size++;
        } else {
            ultimo.setPrevio(nuevoNodo);
            nuevoNodo.setSiguiente(ultimo);
            ultimo = nuevoNodo;
            size++;
        }
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        } else if (size == 1){
            T temp = primero.getValue();
            primero = null;
            ultimo = null;
            size--;
            return temp;
        } else{
            T temp = primero.getValue();
            primero = primero.getPrevio();
            primero.getSiguiente().setPrevio(null);
            primero.setSiguiente(null);
            size--;
            return temp;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getFirst() throws EmptyQueueException {
        if(isEmpty()){
            throw new EmptyQueueException();
        } else {
            return primero.getValue();
        }
    }

    public int getSize() { return size; }

    public void mostrarCola() {
        Nodo nodoActual = primero;
        int contador = 0;
        while (contador < size) {
            System.out.print(nodoActual.getValue() + "  ");
            nodoActual = nodoActual.getPrevio();
            contador++;
        }
    }
}
