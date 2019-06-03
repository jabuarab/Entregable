package um.edu.uy.Tads.QueueJope;

import uy.edu.um.prog2.exceptions.EmptyQueueException;

public interface ShoppingQueue {
    void enqueue(int element, int cantProductos);
    void dequeueFrom(int nroCola) throws EmptyQueueException;
}
