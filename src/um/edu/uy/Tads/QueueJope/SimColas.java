package uy.edu.um.prog2.tad.queue;

import uy.edu.um.prog2.exceptions.EmptyQueueException;

import java.util.ArrayList;

public class SimColas implements ShoppingQueue {

    private int cantColas;
    private ArrayList<ListaQueue<Integer>> colas;
    private int[] tiempoPorCola;
    private int[] nroColas;

    public SimColas(int cantColas) {
        this.cantColas = cantColas;
        colas = new ArrayList<>(cantColas);
        tiempoPorCola = new int[cantColas];
        nroColas = new int[cantColas];
        inicializar();
    }

    protected void inicializar() {
        for (int i = 0; i < cantColas; i++) {
            ListaQueue<Integer> cola = new ListaQueue<>();
            colas.add(i, cola);
            nroColas[i] = i;
        }
    }

    @Override
    public void enqueue(int element, int cantProductos) {
        int nroCola = nroColas[0];
        colas.get(nroCola).enqueue(element);
        tiempoPorCola[0] += 5 * cantProductos;
        optimization();
    }

    @Override
    public void dequeueFrom(int nroCola) throws EmptyQueueException {
        colas.get(nroCola).dequeue();
    }

    public void optimization() {
        for (int i = tiempoPorCola.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (tiempoPorCola[j] > tiempoPorCola[j + 1]) {
                    int temp = tiempoPorCola[j + 1];
                    int temp1 = nroColas[j + 1];

                    tiempoPorCola[j + 1] = tiempoPorCola[j];
                    nroColas[j + 1] = nroColas[j];

                    tiempoPorCola[j] = temp;
                    nroColas[j] = temp1;
                }
            }
        }
    }

    public int getCantColas() {
        return cantColas;
    }

    public void mostrarColas() {
        for (int i = 0; i < cantColas; i++) {
            System.out.print("Cola " + i + ":  ");
            colas.get(i).mostrarCola();
            System.out.println("");
        }

    }
}
