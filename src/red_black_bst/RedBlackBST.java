package red_black_bst;

import array.queue.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    // root
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;

        private Value value;

        // Ref to sub-tree
        private Node left;

        // Ref to sub-tree
        private Node right;

        // Count of nodes in sub-tree with root;
        private int N;

        private boolean color;

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }

        private boolean isRed(Node x) {
            if (x == null) {
                return false;
            }

            return x.color = RED;
        }

        private Node rotateLeft(Node h) {
            Node x = h.right;
            h.right = x.left;
            x.left = h;
            x.color = h.color;
            h.color = RED;
            x.N = h.N;
            h.N = 1 + size(h.left) + size(h.right);

            return x;
        }

        private Node rotateRight(Node h) {
            Node x = h.left;
            h.left = x.right;
            x.right = h;
            x.color = h.color;
            h.color = RED;
            x.N = h.N;
            h.N = 1 + size(h.left) + size(h.right);

            return x;
        }

        private void flipColor(Node h) {
            h.color = RED;
            h.left.color = BLACK;
            h.right.color = BLACK;
        }

        public void put(Key key, Value value) {
            root = put(root, key, value);
            root.color = BLACK;
        }

        private Node put(Node h, Key key, Value value) {
            if (h == null) {
                return new Node(key, value, 1, RED);
            }

            int cmp = key.compareTo(h.key);
            if (cmp < 0) {
                h.left = put(h.left, key, value);
            } else if (cmp > 0) {
                h.right = put(h.right, key, value);
            } else {
                h.value = value;
            }

            if (isRed(h.right) && !isRed(h.left)) {
                h = rotateLeft(h);
            }

            if (isRed(h.left) && isRed(h.left.left)) {
                h = rotateRight(h);
            }

            if (isRed(h.left) && isRed(h.right)) {
                flipColor(h);
            }

            h.N = size(h.left) + size(h.right) + 1;

            return h;
        }

//        TODO: deleteMin/deleteMax/delete

        public int size() {
            return size(root);
        }

        private int size(Node x) {
            if (x == null) {
                return 0;
            }

            return x.N;
        }
    }
}
