package priority_queue;

public class Main {
    public static void main(String[] args) {
        String[] array = {"q", "u", "i", "c", "k", "s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};

        HeapSort heapSort = new HeapSort();
        heapSort.sort(array);
        heapSort.show(array);
    }
}
