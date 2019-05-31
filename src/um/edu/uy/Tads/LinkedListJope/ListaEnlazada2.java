package uy.edu.um.prog2.tad.linkedlist;

import uy.edu.um.prog2.exceptions.DireccionInvalidaException;
import uy.edu.um.prog2.exceptions.PosicionInvalidaException;

public class ListaEnlazada2<T> implements Lista<T> {

    private Nodo primero;
    private Nodo<T> ultimo;
    private int size = 0;

    public void add(T value) {
        Nodo<T> nuevoNodo = new Nodo<>(value);

        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            size++;

        } else {
            Nodo nodoActual = primero;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
            nuevoNodo.setPrevio(nodoActual);
            ultimo = nuevoNodo;
            size++;
        }
    }

    public void remove(int position) throws PosicionInvalidaException {
        Nodo nodoActual = primero;

        if (position == 0 && nodoActual != null) {
            primero = nodoActual.getSiguiente();
            primero.setPrevio(null);
            size--;
        }

        int contador = 0;

        if (position < size && position != 0) {
            while (nodoActual != null) {
                if (contador == position) {
                    nodoActual.getPrevio().setSiguiente(nodoActual.getSiguiente());
                    size--;
                    break;
                } else {
                    nodoActual = nodoActual.getSiguiente();
                    contador++;
                }
            }
        } else {
            throw new PosicionInvalidaException();
        }
    }

    public T get(int position) throws PosicionInvalidaException {
        Nodo<T> nodoActual = primero;
        T value = null;
        int contador = 0;
        while (contador != position) {
            if (position > size) {
                throw new PosicionInvalidaException();
            }
            nodoActual = nodoActual.getSiguiente();
            contador++;
        }
        value = nodoActual.getValue();
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
        primero.setPrevio(nuevoPrimerNodo);
        primero = nuevoPrimerNodo;
        if (nuevoPrimerNodo.getSiguiente() == null) {
            ultimo = nuevoPrimerNodo;
        }
    }

    public void addLast(T value) {
        Nodo<T> nuevoNodo = new Nodo<T>(value), nodoActual = ultimo;
        nodoActual.setSiguiente(nuevoNodo);
        nuevoNodo.setPrevio(nodoActual);
        ultimo = nuevoNodo;
    }

    public void mostrarLista() {
        Nodo nodoActual = primero;
        while (nodoActual != null) {
            System.out.println(nodoActual.getValue());
            nodoActual = nodoActual.getSiguiente();
        }
    }

    public void add(int position, T value) throws PosicionInvalidaException {
        Nodo<T> nuevoNodo = new Nodo<>(value);
        Nodo<T> nodoActual = primero;
        int contador = 0;
        if (position > size || position < 0) {
            throw new PosicionInvalidaException();
        }
        if (position == 0) {
            if (size == 0) {
                primero = nuevoNodo;
                size++;
            } else {
                nuevoNodo.setSiguiente(primero);
                primero.setPrevio(nuevoNodo);
                primero = nuevoNodo;
                size++;
                if (nuevoNodo.getSiguiente() == null) {
                    ultimo = nuevoNodo;
                }
            }
        } else {
            while (contador < position - 1) {
                nodoActual = nodoActual.getSiguiente();
                contador++;
            }
            if (nodoActual.getSiguiente() != null) {
                nuevoNodo.setSiguiente(nodoActual.getSiguiente());
                nodoActual.getSiguiente().setPrevio(nuevoNodo);
                nodoActual.setSiguiente(nuevoNodo);
                nuevoNodo.setPrevio(nodoActual);

                size++;
            }
            nodoActual.setSiguiente(nuevoNodo);
            nuevoNodo.setPrevio(nodoActual);
            size++;
        }
    }

    public void visualizar(ListaEnlazada2<Integer> p) throws PosicionInvalidaException {
        for (int i = 0; i < p.size; i++) {
            if (p.get(i) >= this.size) {
                throw new PosicionInvalidaException();
            } else {
                System.out.println(this.get(p.get(i)));
            }
        }
    }

    public void intercambiar(T value, int direccion) throws PosicionInvalidaException, DireccionInvalidaException {
        for (int i = 0; i < this.size; i++) {
            if (value.equals(this.get(i)) && i == 0) {
                if (direccion != 1) {
                    throw new DireccionInvalidaException();
                } else {
                    add(i + 2, this.get(i));
                    remove(i);
                }
            } else if (value.equals(this.get(i)) && i == (size - 1)) {
                if (direccion != -1) {
                    throw new DireccionInvalidaException();
                } else {
                    add(i - 2, this.get(i));
                    remove(i);
                }
            } else {
                if (direccion == 1) {
                    add(i + 2, this.get(i));
                    remove(i);
                } else if (direccion == -1) {
                    add(i - 2, this.get(i));
                    remove(i);
                } else {
                    throw new DireccionInvalidaException();
                }
            }
        }
    }

    public boolean contains(T data) {
        Nodo<T> nodoActual = primero;
        for (int i = 0; i < size; i++) {
            if (nodoActual.getValue().equals(data)) return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
}
