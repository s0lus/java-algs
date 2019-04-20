package priority_queue;

public class MaxPQ<Key extends Comparable<Key>> {

    public MaxPQ() {

    }

    public MaxPQ(int max) {

    }

    public MaxPQ(Key[] a) {

    }

    void insert(Key v) {

    }

    Key max() {

    }

    Key delMax() {

    }

    boolean isEmpty() {
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
