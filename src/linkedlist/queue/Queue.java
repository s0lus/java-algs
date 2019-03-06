package linkedlist.queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

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

    // old
    private Node first;
    // new
    private Node last;

    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Item item) {
        Node oldlast = last;

        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }

        size++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }

        size--;

        return item;
    }
}
