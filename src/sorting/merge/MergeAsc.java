package sorting.merge;

import sorting.Base;

public class MergeAsc extends Base {
    private Comparable[] aux;

    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        aux = new Comparable[a.length];

        // Copy a[lo..hi] to aux[lo..hi]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Merge back to a[lo..hi]
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    @Override
    public void sort(Comparable[] a) {
        int size = a.length;

        // sz - size of sub array
        for (int sz = 1; sz < size; sz += sz) {
            // lo - index in the sub array
            for (int lo = 0; lo < size - sz; lo += sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, size - 1));
            }
        }
    }
}
