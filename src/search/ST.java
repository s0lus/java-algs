package search;

public interface ST<Key, Value> {
    void put(Key key, Value value);

    Value get(Key key);

    // put(key, null);
    void delete(Key key);

    // return get(key) != null;
    boolean contains(Key key);

    // return size() === 0;
    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}