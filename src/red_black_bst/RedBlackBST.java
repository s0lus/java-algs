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
