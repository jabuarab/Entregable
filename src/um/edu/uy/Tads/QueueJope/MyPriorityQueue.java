package uy.edu.um.prog2.tad.queue;

import uy.edu.um.prog2.exceptions.EmptyQueueException;
import uy.edu.um.prog2.exceptions.PosicionInvalidaException;

import java.util.ArrayList;

public class MyPriorityQueue<T> implements PriorityQueue<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size = 0;
    private ArrayList<Integer> prioridades = new ArrayList<>();

    @Override
    public void insert(T element, int prioridad) {
        if (prioridades.size() == 0) {
            prioridades.add(prioridad);
            enqueue(element);
        } else {
            int i = 0;
            while (i < size && prioridad <= prioridades.get(i)) {
                i++;
            }
            prioridades.add(i, prioridad);
            try {
                enqueueByPosition(element, i);
            } catch (PosicionInvalidaException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void enqueue(T element) {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        if (this.isEmpty()) {
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

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else if (size == 1) {
            Nodo<T> temp = primero;
            primero = null;
            ultimo = null;
            size--;
            return temp.getValue();
        } else {
            Nodo<T> temp = primero;
            primero = primero.getPrevio();
            primero.getSiguiente().setPrevio(null);
            primero.setSiguiente(null);
            size--;
            return temp.getValue();
        }
    }

    public void enqueueByPosition(T element, int pos) throws PosicionInvalidaException {
        Nodo<T> nuevoNodo = new Nodo<>(element);
        Nodo<T> nodoActual = primero;
        int posicionFila = 0;
        if (pos > size || pos < 0) {
            throw new PosicionInvalidaException();
        }
        if (pos == 0) {
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
        } else {
            while (posicionFila < pos - 1) {
                nodoActual = nodoActual.getPrevio();
                posicionFila++;
            }
            if (nodoActual.getPrevio() != null) {
                nuevoNodo.setSiguiente(nodoActual);
                nodoActual.getPrevio().setSiguiente(nuevoNodo);
                nuevoNodo.setPrevio(nodoActual.getPrevio());
                nodoActual.setPrevio(nuevoNodo);
                size++;
            } else {
                nodoActual.setPrevio(nuevoNodo);
                nuevoNodo.setSiguiente(nodoActual);
                size++;
            }
        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getFirst() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            return primero.getValue();
        }
    }

    public int getSize() {
        return size;
    }

    public void mostrarCola() {
        Nodo nodoActual = primero;
        int contador = 1;
        while (nodoActual != null && contador <= size) {
            System.out.println(nodoActual.getValue());
            nodoActual = nodoActual.getPrevio();
            contador++;
        }
    }
}
