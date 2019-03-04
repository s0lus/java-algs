package Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> {
    private Item[] elements;
    private int size;

    // Index of first element
    private int first;
    // Index of next available slot
    private int last;

    public Queue(int cap) {
        elements = (Item[]) new Object[cap];
        size = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

    public void enqueue(Item item)
    {
        if (size == elements.length) {
            resize(2 * elements.length);
        }

        elements[last++] = item;

        if (last == elements.length) {
            last = 0;
        }

        size++;
    }

    public Item dequeue()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        Item item = elements[first];

        size--;
        first++;

        if (first == elements.length) {
            first = 0;
        }

        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }

        return item;
    }

    public void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = elements[(first + i) % elements.length];
        }

        elements = temp;
        first = 0;
        last = size;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Queue is empty");
            }

            Item item = elements[(i + first) % elements.length];
            i++;

            return item;
        }
    }
}
