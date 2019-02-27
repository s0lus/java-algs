package Stack;

import java.util.Iterator;

public class MainStackLinkedList {
    public static void main(String[] args) {
        StackLinkedList<String> stack = new StackLinkedList<String>();

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
