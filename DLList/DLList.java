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
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
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

    public static void main(String[] args) {
        DLList<Integer> D = new DLList<Integer>();
        D.addFirst(1);
        D.addFirst(2);
        System.out.println(D.getFirst());
    }
}