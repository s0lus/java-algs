package array.stack;

import java.util.Iterator;

public class Stack<Item> {
    private Item[] elements;
    private int size;

    public Stack(int cap) {
        elements = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void push(Item item) {
        if (size == elements.length) {
            resize(2 * elements.length);
        }

        elements[size++] = item;
    }

    public Item pop() {
        Item item = elements[--size];
        elements[size] = null;

        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }

        return item;
    }

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = elements[i];
        }

        elements = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public Item next() {
            return elements[--size];
        }
    }
}
