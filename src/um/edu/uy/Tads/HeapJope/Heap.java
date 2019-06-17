package um.edu.uy.Tads.HeapJope;

public class Heap<K extends Comparable<K>, T> implements MyHeap<K, T> {

    private HeapNodo<K, T>[] heap;
    private boolean minHeap;
    private int lastPosition = 0;

    public Heap(int size, boolean minHeap) {

        heap = new HeapNodo[size];

        this.minHeap = minHeap;

    }

    @Override
    public void add(K key, T data) {

        int tempPos = 0;

        if (heap[0] == null) {

            heap[0] = new HeapNodo<>(key, data);

        } else {

            lastPosition++;

            tempPos = lastPosition;

            heap[lastPosition] = new HeapNodo<>(key, data);

        }

        if (lastPosition > 0) {

            if (minHeap) {

                while (getParentFrom(tempPos) >= 0 &&
                        heap[getParentFrom(tempPos)].getKey().compareTo(heap[tempPos].getKey()) > 0) {

                    swapNodes(getParentFrom(tempPos), tempPos);

                    tempPos = getParentFrom(tempPos);

                }

            } else {

                while (getParentFrom(tempPos) >= 0 &&
                        heap[getParentFrom(tempPos)].getKey().compareTo(heap[tempPos].getKey()) < 0) {

                    swapNodes(getParentFrom(tempPos), tempPos);

                    tempPos = getParentFrom(tempPos);

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

            int currentPos = 0;

            int bestChild = findBestChild(currentPos);

            while (heap[bestChild].getKey().compareTo(heap[currentPos].getKey()) < 0) {

                swapNodes(currentPos, bestChild);

                currentPos = bestChild;

                bestChild = findBestChild(currentPos);

            }

            return rootTemp;

        }
    }

    @Override
    public int getSize() {
        return lastPosition + 1;
    }

    public void view() {

        for (HeapNodo<K, T> ele : heap) {

            System.out.println(ele.getKey());

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

        int newPos = 2 * pos + 1;

        if (newPos > lastPosition) return lastPosition;
        else return newPos;

    }

    public int getRightChildFrom(int pos) {

        int newPos = 2 * pos + 2;

        if (newPos > lastPosition) return lastPosition;
        else return newPos;

    }
}