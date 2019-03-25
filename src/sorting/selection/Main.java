package sorting.selection;

import sorting.Base;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[] array = {"c", "b", "a"};

        Selection selection = new Selection();
        selection.sort(array);
        selection.show(array);

    }
}
