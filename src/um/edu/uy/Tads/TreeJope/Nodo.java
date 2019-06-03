package um.edu.uy.Tads.TreeJope;

import um.edu.uy.Tads.KeyNotFoundException;

public class Nodo<K extends Comparable<K>, T> {

    private K key;
    private T data;
    private Nodo<K, T> parent;
    private Nodo<K, T> leftChild;
    private Nodo<K, T> rightChild;

    public Nodo(K key, T data) {
        this.key = key;
        this.data = data;
        parent = null;
        leftChild = null;
        rightChild = null;

    }

    public T find(K key) throws KeyNotFoundException {
        if (this.getKey().compareTo(key) > 0) {
            if (this.getLeftChild() == null) {
                throw new KeyNotFoundException();
            } else {
                return this.getLeftChild().find(key);
            }
        } else if (this.getKey().compareTo(key) < 0) {
            if (this.getRightChild() == null) {
                throw new KeyNotFoundException();
            } else {
                return this.getRightChild().find(key);
            }
        } else {
            return getData();
        }
    }

    public boolean contains(K key) {
        if (this.getKey().compareTo(key) > 0) {
            if (this.getLeftChild() == null) {
                return false;
            } else {
                return this.getLeftChild().contains(key);
            }
        } else if (this.getKey().compareTo(key) < 0) {
            if (this.getRightChild() == null) {
                return false;
            } else {
                return this.getRightChild().contains(key);
            }
        } else {
            return true;
        }
    }

    public void add(K key, T data) {
        if (this.getKey().compareTo(key) > 0) {
            if (this.getLeftChild() == null) {
                Nodo<K, T> nuevoNodo = new Nodo<>(key, data);
                this.setLeftChild(nuevoNodo);
                nuevoNodo.setParent(this);
            } else {
                this.getLeftChild().add(key, data);
            }
        } else if (this.getKey().compareTo(key) < 0) {
            if (this.getRightChild() == null) {
                Nodo<K, T> nuevoNodo = new Nodo<>(key, data);
                this.setRightChild(nuevoNodo);
                nuevoNodo.setParent(this);
            } else {
                this.getRightChild().add(key, data);
            }
        }
    }

    public Nodo<K, T> delete(K key) {
        if (this.key.compareTo(key) > 0) {

            if (rightChild != null) leftChild = leftChild.delete(key);

        } else if (this.key.compareTo(key) < 0) {

            if (rightChild != null) rightChild = rightChild.delete(key);

        } else if (leftChild != null && leftChild != null) {

            Nodo<K, T> temp = rightChild.findMin();
            this.setKey(temp.getKey());
            this.setData(temp.getData());
            rightChild = rightChild.delete(temp.getKey());
        } else {
            if (this.getLeftChild() != null) {
                return leftChild;
            } else {
                return rightChild;
            }
        }
        return this;
    }


    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Nodo<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Nodo<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Nodo<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public Nodo<K, T> getParent() {
        return parent;
    }

    public void setParent(Nodo<K, T> parent) {
        this.parent = parent;
    }

    public boolean isLeaf() {
        if (this.getLeftChild() == null && this.getRightChild() == null) return true;
        else return false;
    }

    public Nodo<K, T> findMin() {
        Nodo<K, T> temp = this;
        if (this.getLeftChild() != null) {
            temp = this.getLeftChild().findMin();
        }
        return temp;
    }
}
