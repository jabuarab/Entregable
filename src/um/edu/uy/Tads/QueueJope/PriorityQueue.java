package um.edu.uy.Tads.QueueJope;

public interface PriorityQueue<T> extends MyQueue<T> {
    void insert(T element, int prioridad);
}
