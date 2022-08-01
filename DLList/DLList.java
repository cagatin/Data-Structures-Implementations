// Doubly Linked List with prev and next pointers.
public class DLList<T> {
    private class Node {
        T val;
        Node next;
        Node prev;

        public Node(T item, Node n, Node p) {
            val = item;
            next = n;
            prev = p;
        }
    }

    // Instance variables
    private Node sentinel;
    public int size;

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
        size += 1;
    }

    // Add an item to the front of the DLList
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    // Add an item to the end of the DLList
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    // Get the value of the front node
    public T getFirst() {
        return sentinel.next.val;
    }

    // Get the value of the last node
    public T getLast() {
        return sentinel.prev.val;
    }

    // remove the node at the front of the DLList
    public void removeFirst() {
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
    }

    // remove the node at the end of the DLList
    public void removeLast() {
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
    }

    // return the number of nodes in the list
    public int size() {
        return size;
    }

    // returns true if the list contains element 'item'
    public boolean contains(T item) {
        if (size == 0) {
            return false;
        }

        Node curr = sentinel.next;
        while (curr != sentinel) {
            if (curr.val == item) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // adds an element at an arbitrary location
    public void add(T item, int pos) {
        if (pos > size() - 1) {
            throw new Error("Position exceeds size of the linked list.");
        }
        if (pos < 0) {
            throw new Error(
                    "Position must be a valid number greater than 0, and less than the number of nodes in the List.");
        }
        if (pos == 0) {
            addFirst(item);
        }
        if (pos == size() - 1) {
            addLast(item);
        }

        Node curr = sentinel;
        while (pos != 0) {
            curr = curr.next;
            pos--;
        }
        curr.next = new Node(item, curr.next, curr);
        curr.next.next.prev = curr.next;
        size += 1;
    }

    public static void main(String[] args) {
        DLList<Integer> D = new DLList<Integer>();

        System.out.println(D.contains(1));
        System.out.println(D.contains(3));
        System.out.println(D.contains(20));
        System.out.println(D.contains(15));
    }
}