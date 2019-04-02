package sorting.merge;

public class Main {
    public static void main(String[] args) {
        String[] array = {"e", "e", "g", "m", "r", "a", "c", "e", "r", "t"};

        int len = array.length;

        Merge merge = new Merge();
        merge.sort(array, 0, len - 1);
        merge.show(array);

    }
}
