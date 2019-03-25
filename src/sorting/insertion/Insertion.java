package sorting.insertion;

import sorting.Base;

public class Insertion extends Base {
    @Override
    public void sort(Comparable[] a) {
        int size = a.length;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exchange(a, j, j - 1);
                }
            }
        }
    }
}
