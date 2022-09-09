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

    /*
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

    /*
     * Returns the value associated w/ the given key.
     * 
     * @param key: the key to search for within the symbol table.
     * 
     * @return: the value associated w/ the given key is in the symbol table
     * and {@code null} if the key is not in the symbol table.
     * 
     * @throws: IlelgalArgumentException if {@code key} is {@code null}.
     */
    public Value get(Key key) {
        // pass the root and the desired key to the getHelper()
        return getHelper(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains cannot be null.");
        }
        // if the Node is empty, return null (No value found).
        if (x == null) {
            return null;
        }
    }
}
