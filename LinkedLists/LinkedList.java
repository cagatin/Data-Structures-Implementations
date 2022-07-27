public class LinkedList<T> {
    // Private Node Class that hides the underlying implementation
    private class Node {
        T item;
        Node next;

        public Node(T i, Node n) {
            this.item = i;
            this.next = n;
        }
    }

    private Node sentinel;
    public int size;

    // Constructor for Linked List
    public LinkedList(T item) {
        sentinel = new Node(item, null);
        size = 1;
    }

    // Constructor for empty linked list
    public LinkedList() {
        sentinel = new Node(null, null);
        size = 0;
    }
}