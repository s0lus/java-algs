package sorting.quick;

public class Main {
    public static void main(String[] args) {
        String[] array = {"q", "u", "i", "c", "k", "s", "o", "r", "t", "e", "x", "a", "m", "p", "l", "e"};

        Quick quick = new Quick();
        quick.sort(array);
        quick.show(array);
    }
}
