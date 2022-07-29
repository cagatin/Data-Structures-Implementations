// Doubly Linked List with prev and next pointers.
public class DLList<T> {
    private class Node {
        public T val; // item in the linked list
        public Node next; // next node in the linked list
        public Node prev; // prev node in the linked list

        public Node(T v, Node n, Node p) {
            val = v;
            next = n;
            prev = p;
        }
    }

    // Instance variables
    private Node sentinel; // sentinel node which acts as the head of the linked list.
    public int size; // cache the size of the linked list

    // Constructor for empty DLList
    public DLList() {
        // Initialize the sentinel node with null values.
        sentinel = new Node(null, null, null);

        // set the next pointer of the sentinel node to point at the sentinel.
        sentinel.next = sentinel;

        // set the prev pointer of the sentinel node to point at the sentinel.
        sentinel.prev = sentinel;

        size = 0;
    }

    // Constructor for DLList
    public DLList(T item) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(item, sentinel, sentinel);
        size = 1;
    }

    // getter for size of linked list
    public int size() {
        return size;
    }

    // add to the front of the linked list
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    // retrieve the first item in the linked list
    public T getFirst() {
        return sentinel.next.val;
    }

    // remove the first item from the linked list
    public void removeFirst() {
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
    }

    // add to the end of the linked list
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    // retrieve the last item from the linked list
    public T getLast() {
        return sentinel.prev.val;
    }

    // remove the last item in the linked list
    public void removeLast() {
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
    }

    public static void main(String[] args) {
        DLList<Integer> D = new DLList<Integer>();
        D.addFirst(2);
        D.addLast(3);
        D.addFirst(7);
        D.addLast(6);
        D.addLast(1);

        D.removeFirst();
        D.removeLast();

        System.out.println(D.getFirst());
        System.out.println(D.getLast());
    }
}