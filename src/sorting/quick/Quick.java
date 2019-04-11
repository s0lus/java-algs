package sorting.quick;

import sorting.Base;

public class Quick extends Base {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);
        // Sort left part
        sort(a, lo, j - 1);
        // Sort right part
        sort(a, j + 1, hi);
    }

    // Partition on a[lo..i-1], a[i], a[i+1..hi]
    private int partition(Comparable[] a, int lo, int hi) {
        // Left lookup index
        int i = lo;
        // Right lookup index
        int j = hi + 1;
        // Central element
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exchange(a, i, j);
        }

        exchange(a, lo, j);

        // a[lo..j-1] <= a[j] <= a[j+1..hi]
        return j;
    }
}
