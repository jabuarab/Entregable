package uy.edu.um.prog2.tad.linkedlist;

public class ListaEnlazada<T> implements Lista<T> {

    private Nodo<T> primero;

    public void add(T value) {

        Nodo<T> nuevoNodo = new Nodo<>(value);

        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> nodoActual = primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
    }

    public void remove(int position) {

        Nodo<T> nodoActual = primero;

        if (position == 0 && nodoActual != null) {
            primero = nodoActual.getSiguiente();
        }

        int contador = 0;

        if (position > 0) {
            while (nodoActual.getSiguiente().getSiguiente() != null && contador < position - 1) {
                nodoActual = nodoActual.getSiguiente();
                contador++;
            }
            nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
        }
    }

    public T get(int position) {
        Nodo<T> nodoActual = primero;
        T value = null;
        int contador = 0;

        while (contador < position) {
            nodoActual = nodoActual.getSiguiente();
            contador++;
        }
        if (contador == position) {
            value = nodoActual.getValue();
        }
        return value;
    }

    public boolean elementoExiste(T value) {
        boolean existencia = true;
        Nodo nodoActual = primero;
        while (!value.equals(nodoActual.getValue()) && nodoActual.getSiguiente() != null) {
            nodoActual = nodoActual.getSiguiente();
        }
        if (!value.equals(nodoActual.getValue())) {
            existencia = false;
        }
        return existencia;
    }

    public void addFirst(T value) {
        Nodo<T> nuevoPrimerNodo = new Nodo<>(value);
        nuevoPrimerNodo.setSiguiente(primero);
        primero = nuevoPrimerNodo;
    }

    public void addLast(T value) {
        Nodo<T> nuevoNodo = new Nodo<T>(value), nodoActual = primero;

        while (nodoActual.getSiguiente() != null) {
            nodoActual = nodoActual.getSiguiente();
        }
        nodoActual.setSiguiente(nuevoNodo);
    }

    public void mostrarLista() {
        Nodo nodoActual = primero;
        while (nodoActual != null) {
            System.out.println(nodoActual.getValue());
            nodoActual = nodoActual.getSiguiente();
        }
    }
}
