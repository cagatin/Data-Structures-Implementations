package BST;

public class BST<Key extends Comparable<Key>, Value> {
    // Private Node Class
    private class Node {
        private Key key; // value of the key in the Node
        private Value val; // associated data in the Node
        private Node left; // left child Node
        private Node right; // right child Node;
        private int size; // number of nodes in the subtree

        // constructor for a Node
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    // root of the bst
    private Node root;

    // Initializes an empty BST
    public BST() {
    };

    // Checks to see if the BST is empty
    public boolean isEmpty() {
        return size() == 0;
    }

    // returns the number of key-value pairs in the BST.
    public int size() {
        // pass the root node to the sizeHelper funciton to determine the size of the
        // BST.
        return sizeHelper(root);
    }

    // private helper method which returns the number of key-val apirs in the BST.
    private int sizeHelper(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }

    /**
     * Function which checks if the BST contains a given key.
     * 
     * @param key: key to search for within the BST
     * 
     * @return: {@code: true} if the symbol table contains the key.
     * 
     * @return: {@code: false} oterwise.
     * 
     * @throws IllegalArgumentException if {@code key} is {@code null}.
     */
    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains cannot be null.");
        }
        // the result of get() returns the value associated witha given key.
        return get(key) != null;
    }

    /**
     * Returns the value associated w/ the given key.
     * 
     * @param key: the key to search for within the symbol table.
     * 
     * @return: the value associated w/ the given key is in the symbol table
     *          and {@code null} if the key is not in the symbol table.
     * 
     * @throws: IlelgalArgumentException if {@code key} is {@code null}.
     */
    public Value get(Key key) {
        // pass the root and the desired key to the getHelper()
        return getHelper(root, key);
    }

    private Value getHelper(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains cannot be null.");
        }
        // if the Node is empty, return null (No value found).
        if (x == null) {
            return null;
        }
        // cmp == 0 --> Keys are equal.
        // cmp = negative --> key is smaller than x.key
        // cmp = positive --> key is larger than x.key
        int cmp = key.compareTo(x.key);
        if (cmp == 1) {
            return x.val;
        } else if (cmp > 0) {
            return getHelper(x.right, key);
        } else {
            return getHelper(x.left, key);
        }
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the
     * old
     * value w/ a new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if
     * the specified value is {@code null}.
     * 
     * @param key: the key to insert.
     * @param val: the value to insert.
     * @throws: IllegalArgumetnException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (val == null) {
            // delete(key);
            return;
        }

        // pass the root node into the put helepr
        root = putHelper(root, key, val);
    }

    // helper for put operation.
    private Node putHelper(Node x, Key key, Value val) {
        if (x == null) { // Base Case: Insert the key as a child of the leaf Node.
            return new Node(key, val, 1); // Place new Node at the leaf.
        }

        int cmp = key.compareTo(x.key);

        if (cmp < 0) { // Case: Key is smaller than the key at the current node.
            x.left = putHelper(x.left, key, val); // Reassign left pointer to result of insertion.
        } else if (cmp > 0) { // Case: Key is larger than the key at the current node.
            x.right = putHelper(x.right, key, val); // Reassign right pointer to tresult of insertion.
        } else { // Case: Key and key at current node are equal.
            x.val = val; // Overwrite old key with new key.
        }
        x.size = 1 + sizeHelper(x.left) + sizeHelper(x.right); // Update the size variable of the BST
        return x;
    }
}
