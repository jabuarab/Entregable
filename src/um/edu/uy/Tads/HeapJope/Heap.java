package um.edu.uy.Tads.HeapJope;

public class Heap<K extends Comparable<K>, T> implements MyHeap<K, T> {

    private int size;
    private HeapNodo<K, T>[] heap;
    private boolean minHeap;
    //private HeapNodo<K, T> root = heap[0];
    private int lastPosition = 0;

    public Heap(int size, boolean minHeap) {

        this.size = size;

        heap = new HeapNodo[size];

        this.minHeap = minHeap;

    }

    @Override
    public void add(K key, T data) {

        HeapNodo<K, T> lastNode;

        if (heap[0] == null) {

            heap[0] = new HeapNodo<>(key, data);

        } else {

            lastPosition++;

            heap[lastPosition] = new HeapNodo<>(key, data);

        }

        if (lastPosition > 0) {

            if (minHeap) {

                while (getParentFrom(lastPosition) >= 0 &&
                        heap[getParentFrom(lastPosition)].getKey().compareTo(heap[lastPosition].getKey()) > 0) {

                    swapNodes(getParentFrom(lastPosition), lastPosition);

                }

            } else {

                while (getParentFrom(lastPosition) >= 0 &&
                        heap[getParentFrom(lastPosition)].getKey().compareTo(heap[lastPosition].getKey()) < 0) {

                    swapNodes(getParentFrom(lastPosition), lastPosition);

                }
            }
        }
    }

    @Override
    public T removeRoot() {

        if (lastPosition == 0) {

            T data = heap[0].getData();

            heap[0] = null;

            return data;

        } else {

            T rootTemp = heap[0].getData();

            heap[0] = heap[lastPosition];

            heap[lastPosition] = null;

            lastPosition--;

            int bestChild = findBestChild(0);

            while (heap[bestChild].getKey().compareTo(heap[0].getKey()) < 0) {

                swapNodes(0, bestChild);

            }

            return rootTemp;

        }
    }

    @Override
    public int getSize() {
        return lastPosition + 1;
    }

    public void view() {

        for (int i = 0; i < level(0); i++) {

            for (int j = 1; i < level(0); j++) {

                System.out.println(" ");

            }
        }
    }

    public void swapNodes(int node1Pos, int node2Pos) {

        HeapNodo<K, T> nodoTemp = heap[node1Pos];

        heap[node1Pos] = heap[node2Pos];

        heap[node2Pos] = nodoTemp;

    }

    public int findBestChild(int pos) {

        if (minHeap) {

            if (heap[getLeftChildFrom(pos)] != null && heap[getRightChildFrom(pos)] != null) {

                if (heap[getLeftChildFrom(pos)].getKey().compareTo(heap[getRightChildFrom(pos)].getKey()) > 0) {

                    return getRightChildFrom(pos);

                } else return getLeftChildFrom(pos);

            } else if (heap[getLeftChildFrom(pos)] != null || heap[getRightChildFrom(pos)] != null) {

                if (heap[getLeftChildFrom(pos)] == null) return getRightChildFrom(pos);

                else return getLeftChildFrom(pos);

            }

            return pos;

        } else {

            if (heap[getLeftChildFrom(pos)] != null && heap[getRightChildFrom(pos)] != null) {

                if (heap[getLeftChildFrom(pos)].getKey().compareTo(heap[getRightChildFrom(pos)].getKey()) > 0) {

                    return getRightChildFrom(pos);

                } else if (heap[getLeftChildFrom(pos)] != null) return getLeftChildFrom(pos);

            } else if (heap[getLeftChildFrom(pos)] != null || heap[getRightChildFrom(pos)] != null) {

                if (heap[getLeftChildFrom(pos)] == null) return getRightChildFrom(pos);

                else return getLeftChildFrom(pos);

            }

            return pos;

        }
    }

    public int level(int pos) {

        int nivel;

        if (heap[0] == null) return 0;

        if (heap[getLeftChildFrom(pos)] == null) {

            return 1;

        } else {

            pos = getLeftChildFrom(pos);

            nivel = level(pos);

            return nivel + 1;

        }
    }

    public HeapNodo<K, T>[] getHeap() {

        return heap;

    }

    public HeapNodo<K, T> getRoot() {

        return heap[0];

    }

    public int getParentFrom(int pos) {

        return (pos - 1) / 2;

    }

    public int getLeftChildFrom(int pos) {

        return 2 * pos + 1;

    }

    public int getRightChildFrom(int pos) {

        return (2 * pos + 2);

    }




}
