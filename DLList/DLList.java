// Doubly Linked List with prev and next pointers.
public class DLList<T> {
    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T v, Node n, Node p) {
            value = v;
            n = next;
            prev = p;
        }
    }

    private Node sentinel;
    public int size
}