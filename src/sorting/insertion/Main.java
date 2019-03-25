package sorting.insertion;

public class Main {
    public static void main(String[] args) {
        String[] array = {"c", "b", "a"};

        Insertion insertion = new Insertion();
        insertion.sort(array);
        insertion.show(array);
    }
}
