package um.edu.uy.Tads.Heap;

public class Heap<T, K extends Comparable> {
    private int length;
    private int last;
    private Nodo<T, K>[] heapArray = new Nodo[length]; //

    public Heap(int length) {
        this.length = length;
        this.heapArray = new Nodo[length];
        last = 0;
    }

    public Heap() {
        this.length = 1000;
        this.heapArray = new Nodo[length];
        last = 0;
    }




    public void add(Nodo<T, K> nodotemp) {
        heapArray[last] = nodotemp;
        swapup(last);
        last = last + 1;
    }

    public void swapup(int i) {
        Nodo<T, K> a = heapArray[i];
        Nodo<T, K> aux;
        int n = a.compareTo(heapArray[(i - 1) / 2]);
        switch (n) {
            case 1:
                aux = a;
                heapArray[i] = heapArray[(i - 1) / 2];
                heapArray[(i - 1) / 2] = aux;
                break;
        }

        if (n == 1) {
            i = (i - 1) / 2;
            swapup(i);
        }
    }

    public void swap(int i) {
        if (i < (length + 2) / 2) {
            throw new IndexOutOfBoundsException();
        }


        Nodo<T, K> a = heapArray[i];
        Nodo<T, K> auxiliar;
        int n = 0;    // variable que dice en que direccion se hace el cambio
        int iswap = i;
// selecciona el caso
        boolean hasLeftChild = false;
        if (heapArray[2 * i + 1] != null) {
            hasLeftChild = true;
        }


        boolean hasRigthChild = false;
        if (heapArray[2 * i + 2] != null) {
            hasRigthChild = true;
        }


        if (hasLeftChild && hasRigthChild) {
            int R = a.compareTo(heapArray[2 * i + 2]);
            int L = a.compareTo(heapArray[2 * i + 1]);
            int def = L * R;
            boolean skerry = true;         // skerry es un boolean temporal que rolo me obligo a llamarla asi
            while (skerry) {
                if (def == 1) {
                    if (L == 1) {
                        n = 0;
                        skerry = false;
                    } else if (L == -1) {
                        n = heapArray[2 * i + 2].compareTo(heapArray[2 * i + 1]);
                        skerry = false;
                    }
                } else if (def == 0) {
                    if (L != 0)
                        n = L;
                    else {
                        n = -R;
                    }

                } else if (def == -1) {
                    n = L;
                }

            }
        } else if (!hasRigthChild) {
            int C = a.compareTo(heapArray[2 * i + 1]);
            switch (C) {
                case 1:
                    n = 0;
                    break;
                case 0:
                    n = 0;
                    break;
                case -1:
                    n = -1;
                    break;

            }
        }


        // 1 derecha
        //-1 izquierda
        // 0 nun

        switch (n) {
            case 0:
                break;
            case 1:
                iswap = 2 * i + 2;

                auxiliar = heapArray[2 * i + 2];
                heapArray[2 * i + 2] = a;
                heapArray[i] = auxiliar;
                // hago el cambio si es necesario
                break;
            case -1:
                iswap = 2 * i + 1;

                auxiliar = heapArray[2 * i + 1];
                heapArray[2 * i + 1] = a;
                heapArray[i] = auxiliar;

                break;
        }


        if (iswap != i) {
            swap(iswap);       //   recurcibidad
        }


    }

    public T get(K key) {
        int j=0;
        boolean tempbool = true;
        while (tempbool && j < length) {
            j = j + 1;
            if (heapArray[j].getKey().equals(key)) {
                tempbool = false;
            }
        }
        if (!heapArray[j].getKey().equals(key)) {
            throw new NullPointerException();
        }
        return heapArray[j].getValue();
    }

    public Nodo<T, K> eliminar() {
        Nodo<T, K> aux = heapArray[0];
        heapArray[0] = heapArray[last];
        heapArray[last] = null;
        swap(0);
        last = last - 1;
        return aux;
    }

    public int getLength() {
        return length;
    }

    public Nodo<T, K> getFirst() {
        return heapArray[0];
    }

    public Nodo<T, K> getLast() {
        return heapArray[last - 1];
    }
}
