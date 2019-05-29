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

        // Returns value related with key in sub-tree with root x.
        // Returns null if key in sub-tree with root x doesn't exists.
        private Value get(Node x, Key key) {
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return get(x.left, key);
            } else if (cmp > 0) {
                return get(x.right, key);
            } else {
                return x.value;
            }
        }

        private Node put(Node x, Key key, Value value) {
            // If key exists in sub-tree with root x, then change him value to value.
            // Else add to sub-tree new node with key (key) and value (value).
            if (x == null) {
                return new Node(key, value, 1);
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x.left = put(x.left, key, value);
            } else if (cmp > 0) {
                x.right = put(x.right, key, value);
            } else {
                x.value = value;
            }

            x.N = size(x.left) + size(x.right) + 1;

            return x;
        }

        private Node min(Node x) {
            if (x.left == null) {
                return x;
            }

            return min(x.left);
        }

        private Node max(Node x) {
            if (x.right == null) {
                return x;
            }

            return max(x.right);
        }

        private Node floor(Node x, Key key) {
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }

            if (cmp < 0) {
                return floor(x.left, key);
            }

            Node t = floor(x.right, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }

        private Node ceiling(Node x, Key key) {
            if (x == null) {
                return null;
            }

            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                return x;
            }

            if (cmp > 0) {
                return ceiling(x.right, key);
            }

            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }

        // Returns node contains key with rank k
        private Node select(Node x, int k) {
            if (x == null) {
                return null;
            }

            int t = size(x.left);
            if (t > k) {
                return select(x.left, k);
            } else if (t < k) {
                return select(x.right, k - t - 1);
            } else {
                return x;
            }
        }

        // Returns count of keys < x.key in sub-tree with root x
        private int rank(Key key, Node x) {
            if (x == null) {
                return 0;
            }

            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                return rank(key, x.left);
            } else if (cmp > 0) {
                return 1 + size(x.left) + rank(key, x.right);
            } else {
                return size(x.left);
            }
        }

        public Value get(Key key) {
            return get(root, key);
        }

        // Key finding. If exists - change value, else increment tree
        public void put(Key key, Value value) {
            root = put(root, key, value);
        }

        public Key min() {
            return min(root).key;
        }

        public Key max() {
            return max(root).key;
        }

        public Key floor(Key key) {
            Node x = floor(root, key);
            if (x == null) {
                return null;
            }

            return x.key;
        }

        public Key ceiling(Key key) {
            Node x = ceiling(root, key);
            if (x == null) {
                return null;
            }

            return x.key;
        }

        public Key select(int k) {
            return select(root, k).key;
        }

        public int rank(Key key) {
            return rank(key, root);
        }

        // TODO: delete/deleteMin/deleteMax/keys
    }
}
