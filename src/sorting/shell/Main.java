package sorting.shell;

public class Main {
    public static void main(String[] args) {
        String[] array = {"s", "h", "e", "l", "l", "s", "o", "r", "t"};

        Shell shell = new Shell();
        shell.sort(array);
        shell.show(array);
    }
}
