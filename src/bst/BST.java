package bst;

public class BST<Key extends Comparable<Key>, Value> {
    // root
    private Node root;

    private class Node {
        private Key key;

        private Value value;

        // Ref to sub-tree
        private Node left;

        // Ref to sub-tree
        private Node right;

        // Count of nodes in sub-tree with root;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) {
                return 0;
            }

            return x.N;
        }

        public Value get(Key key) {
            // TODO:
        }

        public void put(Key key, Value value) {
            // TODO:
        }

        // TODO: min/max/floor/ceiling/select/rank/delete/deleteMin/deleteMax/keys
    }
}
