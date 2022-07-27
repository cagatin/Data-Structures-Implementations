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

    // return the number of items in the Linked List
    public int size() {
        return size;
    }

    // Add an element to the start of the linked list
    public void addFirst(T elem) {
        sentinel.next = new Node(elem, sentinel.next);
        size += 1;
    }

    // Get the first item in the linked list
    public T getFirst() {
        return sentinel.next.item;
    }

    // Add an item to the end of the LinkedList
    public void addLast(T elem) {
        // create a pointer to traverse through the linked list.
        Node head = sentinel;

        /*
         * While the head pointer's next variable is not equal to a null value...
         * advance the head pointer to the next link!
         */
        while (head.next != null) {
            head = head.next;
        }
        // add the new item to the linked list
        head.next = new Node(elem, null);
    }

    public static void main(String[] args) {
        LinkedList<Integer> L = new LinkedList<Integer>();
        L.addFirst(20);
        L.addFirst(15);
        L.addFirst(10);
        System.out.println(L.getLast());
    }
}