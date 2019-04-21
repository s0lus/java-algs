package priority_queue;

import sorting.Base;

public class HeapSort extends Base {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;

        // Create pyramid
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }

        // Exchange a[1] with a[N] and restore pyramid
        while (N > 1) {
            exchange(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private void sink(Comparable[] a, int k, int size) {
        while (2 * k <= size) {
            int j = 2 * k;

            if (j < size && less(a, j, j + 1)) {
                j++;
            }

            if (!less(a, k, j)) {
                break;
            }

            exchange(a, k, j);

            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    public void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }
}
