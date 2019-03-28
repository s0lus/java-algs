package sorting.shell;

import sorting.Base;

public class Shell extends Base {
    @Override
    public void sort(Comparable[] a) {
        int size = a.length;
        int h = 1;

        // Sequence of DESC values
        // 1/2 * (3^k - 1)
        // 1, 4, 13, 40, 121, 364, 1093
        while (h < size / 3) {
            h = 3 * h + 1;
        }

        // h-sort
        while (h >= 1) {
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (less(a[j], a[j-h])) {
                        exchange(a, j, j-h);
                    }
                }
            }

            h /= 3;
        }
    }
}
