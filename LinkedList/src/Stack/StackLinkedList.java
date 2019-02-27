package Stack;

import java.util.Iterator;

public class StackLinkedList<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Item next() {
            Item item = first.item;
            first = first.next;

            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    // top of the stack
    private Node first;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        Node oldfirst = first;

        first = new Node();
        first.item = item;
        first.next = oldfirst;

        size++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;

        size--;

        return item;
    }
}
