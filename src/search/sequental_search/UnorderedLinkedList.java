package search.sequental_search;

import search.ST;

public class UnorderedLinkedList<Key, Value> implements ST {

    // First element in a linked list
    private Node first;

    // node of linked list
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(Object key, Object value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = (Value)value;

                return;
            }
        }

        first = new Node((Key)key, (Value)value, first);
    }

    @Override
    public Object get(Object key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }

        return null;
    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable keys() {
        return null;
    }
}
