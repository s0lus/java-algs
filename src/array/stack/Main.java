package array.stack;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>(4);

        String[] str = "to be or not to - be - - that - - - is".split(" ");

        for (String s : str) {
            if (!s.equals("-")) {
                stack.push(s);
            } else if (!stack.isEmpty()) {
                System.out.println(stack.pop());
            }
        }

        System.out.println("In stack " + stack.size());

        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
