public class ClosedHash<K extends Comparable<K>, T> {

    private int size;
    private HashNode<K, T>[] hash;
    private int mod;
    private int config;

    public ClosedHash(int size, int mod, int config) {
        this.size = size;
        hash = new HashNode[size];
        this.mod = mod;
        this.config = config;
    }

    public void putL(K key, T data) {

        int pos = hashFun(key);

        if (hash[pos] == null) {

            hash[pos] = new HashNode<>(key, data, 0);

        } else if (hash[pos].getState() == 1) {

            hash[pos].setKey(key);
            hash[pos].setData(data);
            hash[pos].setState(0);

        } else {

            int i = pos;

            while (hash[i] != null && hash[i].getState() == 0) {

                i++;

                if (i >= hash.length) i = 0;

            }

            if (hash[i] == null) {

                hash[i] = new HashNode<>(key, data, 0);

            } else {

                hash[i].setKey(key);
                hash[i].setData(data);
                hash[i].setState(0);

            }
        }
    }

    public void putC(K key, T data) {

        int pos = hashFun(key);

        if (hash[pos] == null) {

            hash[pos] = new HashNode<>(key, data, 0);

        } else if (hash[pos].getState() == 1) {

            hash[pos].setKey(key);
            hash[pos].setData(data);
            hash[pos].setState(0);

        } else {

            int i = pos, j = 0;

            while (hash[i] != null && hash[i].getState() == 0) {

                j++;

                i = i + (int) Math.pow(j, 2);

                if (i == hash.length) {

                    i = 0;

                } else if (i > hash.length) {

                    while (i > hash.length) {

                        i = i - hash.length;

                    }
                }
            }

            if (hash[i] == null) {

                hash[i] = new HashNode<>(key, data, 0);

            } else {

                hash[i].setKey(key);
                hash[i].setData(data);
                hash[i].setState(0);

            }
        }

    }

    public T getL(K key) throws KeyNotFoundException {

        int pos = hashFun(key);

        while (hash[pos] != null && hash[pos].getState() == 0 && hash[pos].getKey().compareTo(key) != 0) {


            pos = (funcionLineal(pos)) % size;

        }

        if (hash[pos] == null || hash[pos].getState() == 1) throw new KeyNotFoundException();

        return hash[pos].getData();

    }

    public int funcionLineal(int pos) {
        return pos + 1;
    }

    public int funcionCuadratica(int pos) {
        return
    }

    public T getC(K key) throws KeyNotFoundException {

        int pos = hashFun(key), j = 0;

        while (hash[pos] != null && hash[pos].getState() == 0 && hash[pos].getKey().compareTo(key) != 0) {

            j++;

            pos = pos + (int) Math.pow(j, 2);

            if (pos == hash.length) {

                pos = 0;

            } else if (pos > hash.length) {

                while (pos > hash.length) {

                    pos = pos - hash.length;

                }
            }
        }

        if (hash[pos] == null || hash[pos].getState() == 1) throw new KeyNotFoundException();

        return hash[pos].getData();

    }

    public boolean containsL(K key) {

        int pos = hashFun(key);

        while (hash[pos] != null && hash[pos].getState() == 0 &&hash[pos].getKey().compareTo(key) != 0) {

            pos++;

            if (pos == hash.length) {

                pos = 0;

            } else if (pos > hash.length) {

                while (pos > hash.length) {

                    pos = pos - hash.length;

                }
            }
        }

        return hash[pos] != null && hash[pos].getState() != 1;

    }

    private HashNode<K, T> getL2(K key) throws KeyNotFoundException {

        int pos = hashFun(key);

        while (hash[pos] != null && hash[pos].getState() == 0 && hash[pos].getKey().compareTo(key) != 0) {

            pos++;

            if (pos >= hash.length) pos = 0;

        }

        if (hash[pos] == null || hash[pos].getState() == 1) throw new KeyNotFoundException();

        return hash[pos];

    }

    private HashNode<K, T> getC2(K key) throws KeyNotFoundException {

        int pos = hashFun(key), j = 0;

        while (hash[pos] != null && hash[pos].getState() == 0 && hash[pos].getKey().compareTo(key) != 0) {

            j++;

            pos = pos + (int) Math.pow(j, 2);

            if (pos == hash.length) {

                pos = 0;

            } else if (pos > hash.length) {

                while (pos > hash.length) {

                    pos = pos - hash.length;

                }
            }
        }

        if (hash[pos] == null || hash[pos].getState() == 1) throw new KeyNotFoundException();

        return hash[pos];

    }

    public boolean containsC(K key) {

        int pos = hashFun(key), j = 0;

        while (hash[pos] != null && hash[pos].getState() == 0 && hash[pos].getKey().compareTo(key) != 0) {

            j++;

            pos = pos + (int)Math.pow(j, 2);

            if (pos == hash.length) {

                pos = 0;

            } else if (pos > hash.length) {

                while (pos > hash.length) {

                    pos = pos - hash.length;

                }
            }
        }

        return hash[pos] != null && hash[pos].getState() != 1;

    }

    public void removeL(K key) throws KeyNotFoundException {

        getL2(key).setState(1);

    }

    public void removeC(K key) throws KeyNotFoundException {

        getC2(key).setState(1);

    }

    public int hashFun(K key) {
        return key.hashCode() % mod;
    }

    public HashNode<K, T>[] getHash() {
        return hash;
    }
}
