package sorting.merge;

public class Main {
    public static void main(String[] args) {
        String[] array1 = {"e", "e", "g", "m", "r", "a", "c", "e", "r", "t"};

        MergeDesc mergeDesc = new MergeDesc();
        mergeDesc.sort(array1, 0, array1.length - 1);
        mergeDesc.show(array1);

        String[] array2 = {"e", "e", "g", "m", "r", "a", "c", "e", "r", "t"};

        MergeAsc mergeAsc = new MergeAsc();
        mergeAsc.sort(array2);
        mergeAsc.show(array2);
    }
}
