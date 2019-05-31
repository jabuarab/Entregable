package uy.edu.um.prog2.tad.stack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements MyStack<T> {

    private int size = 0;
    private T[] stack;

    public ArrayStack(int length) {
        stack = (T[]) new Object[length];
    }

    @Override
    public void pop() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            stack[size-1] = null;
            size--;
        }
    }

    @Override
    public T top() throws EmptyStackException {
        if (size == 0) {
            throw new EmptyStackException();
        } else {
            return stack[size-1];
        }
    }

    @Override
    public void push(T element) {
        stack[size] = element;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void makeEmpty() {
        for (int i = size-1; i >= 0; i--) {
            stack[i] = null;
        }
        size = 0;
    }
}
