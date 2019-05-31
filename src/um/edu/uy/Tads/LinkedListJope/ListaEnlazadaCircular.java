package uy.edu.um.prog2.tad.linkedlist;

import uy.edu.um.prog2.exceptions.PosicionInvalidaException;

public class ListaEnlazadaCircular<T> implements Lista<T> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int size = 0;

    public void add(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);
        if (size == 0) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(primero);
            nuevoNodo.setPrevio(ultimo);
            ultimo = nuevoNodo;
            primero.setPrevio(nuevoNodo);
            size++;
        }
    }

    public void remove(int position) {
        Nodo nodoActual = primero;
        if(position == 0 && nodoActual != null){
            primero = nodoActual.getSiguiente();
            primero.setPrevio(ultimo);
            ultimo.setSiguiente(primero);
            size--;
        }

        int contador = 0;
        if(position > 0 && nodoActual != null){
            while(nodoActual.getSiguiente() != null && contador <= size) {
                if (contador == position) {
                    nodoActual.getPrevio().setSiguiente(nodoActual.getSiguiente());
                    nodoActual = nodoActual.getSiguiente();
                    nodoActual.setPrevio(nodoActual.getPrevio().getPrevio());
                    size--;
                    break;
                }
                nodoActual = nodoActual.getSiguiente();
                contador++;
            }
        }
    }

    public T get(int position) throws PosicionInvalidaException {
        Nodo<T> nodoActual = primero;
        T value = null;
        int contador = 0;
        if(position < size) {
            while (contador != position) {
                nodoActual = nodoActual.getSiguiente();
                contador++;
            }
            value = nodoActual.getValue();
            return value;
        }else {
            throw new PosicionInvalidaException();
        }
    }

    public boolean elementoExiste(T value) {
        boolean existe = false;
        Nodo<T> nodoActual = primero;
        while(!nodoActual.equals(ultimo)){
            if(nodoActual.getValue().equals(value)){
                existe = true;
                break;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return existe;
    }

    public void mostrarLista(){
        Nodo nodoActual = primero;
        while(nodoActual != null){
            System.out.println(nodoActual.getValue());
            nodoActual = nodoActual.getSiguiente();
        }
    }

    public int getSize() {
        return size;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public Nodo<T> getUltimo() {
        return ultimo;
    }
}
