package sorting.selection;

import sorting.Base;

public class Selection extends Base {
    @Override
    public void sort(Comparable[] a) {
        int size = a.length;

        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            exchange(a, i, min);
        }
    }
}
