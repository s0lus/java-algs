package threesum.bad;

import threesum.Timer;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new Random().ints(8000, -1000000, 1000000).toArray();

        Timer timer = new Timer();
        System.out.println("Result: " + count(array));
        double time = timer.elapsedTime();
        System.out.println("Time: " + time + " sec");
    }

    public static int count(int[] array) {
        int size = array.length;
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}


