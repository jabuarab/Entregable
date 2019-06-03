package um.edu.uy.Tads.QueueJope;

import uy.edu.um.prog2.exceptions.EmptyQueueException;

public interface MyQueue<T> {
    void enqueue(T element);
    T dequeue() throws EmptyQueueException;
    boolean isEmpty();
    T getFirst() throws EmptyQueueException;
}
