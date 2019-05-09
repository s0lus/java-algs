package search;

import search.sequental_search.UnorderedLinkedList;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[]{"s", "e", "a", "r", "c", "h", "e", "x", "a", "m", "p", "l", "e"};

        UnorderedLinkedList unorderedLinkedList = new UnorderedLinkedList();

        for (int i = 0; i < array.length; i++) {
            unorderedLinkedList.put(array[i], i);
        }

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ' ');
            System.out.println(unorderedLinkedList.get(array[i]));
        }
    }
}
