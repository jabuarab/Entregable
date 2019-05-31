package uy.edu.um.prog2.tad.queue;

public interface PriorityQueue<T> extends MyQueue<T> {
    void insert(T element, int prioridad);
}
