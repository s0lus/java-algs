package search.binary_search;

import search.ST;

public class BinarySearch<Key extends Comparable<Key>, Value> implements ST {
    private Key[] keys;
    protected Value[] values;
    private int N;

    public BinarySearch(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    @Override
    public void put(Object key, Object value) {
        int i = rank((Key)key);
        if (i < N && keys[i].compareTo((Key)key) == 0) {
            values[i] = (Value)value;

            return;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = (Key)key;
        values[i] = (Value)value;

        N++;
    }

    @Override
    public Object get(Object o) {
        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterable keys() {
        return null;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    // Iterative
    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return lo;
    }

    // Recursive
    public int rankRecursive(Key key, int lo, int hi) {
        if (hi < lo) {
            return hi;
        }

        int mid = lo + (hi - lo) / 2;

        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rankRecursive(key, lo, mid - 1);
        } else if (cmp > 0) {
            return rankRecursive(key, mid + 1, hi);
        } else {
            return mid;
        }
    }
}
