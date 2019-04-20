package priority_queue;

public class MaxPQ<Key extends Comparable<Key>> {
    // Binary heap
    private Key pq[];

    // pq[1..size], pq[0] - not using
    private int size = 0;

    public MaxPQ() {

    }

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public MaxPQ(Key[] a) {

    }

    void insert(Key v) {
        pq[++size] = v;
        swim(size);
    }

    Key max() {

    }

    Key delMax() {
        // Max key from the root
        Key max = pq[1];
        // Exchnage with the latest element
        exchange(1, size--);
        pq[size + 1] = null;
        sink(1);

        return max;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
