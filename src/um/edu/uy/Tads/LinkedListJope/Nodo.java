package uy.edu.um.prog2.tad.linkedlist;

public class Nodo<T> {

    private T value;
    private Nodo<T> siguiente;
    private Nodo<T> previo;



    public Nodo(T value) {
        this.value = value;
        siguiente = null;
        previo = null;
    }

    public T getValue() { return value; }

    public void setValue(T value) { this.value = value; }

    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }

    public Nodo<T> getSiguiente() { return siguiente; }

    public Nodo<T> getPrevio() { return previo; }

    public void setPrevio(Nodo previo) { this.previo = previo; }
}
