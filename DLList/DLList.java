// Doubly Linked List with prev and next pointers.
public class DLList<T> {
    private class Node {
        public T value;
        public Node next;
        public Node prev;

        public Node(T v, Node n, Node p) {
            value = v;
            n = next;
            prev = p;
        }
    }

    private Node sentinel;
    public int size;

    // Constructor for empty DLList
    public DLList() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    // Constructor for DLList
    public DLList(T value) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(value, sentinel, sentinel);
        size = 1;
    }
}