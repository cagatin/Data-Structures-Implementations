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

    // [sentinel | -]--> [1 | -]--> [2 | -]--> [3 | -]--> [4 | null]

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
        size += 1;
    }

    // Retrieve the last item of a linked list
    public T getLast() {
        // Create a pointer to traverse through the linked list.
        Node head = sentinel;

        /*
         * While the head pointer's next variable is not equal to a null value...
         * advance the head pointer to the next link!
         */
        while (head.next != null) {
            head = head.next;
        }

        // At this point, we've reached the end of the linked list. Return the element.
        return head.item;
    }

    // Reverse the linked list;
    public void reverse() {
        Node prev = null; // reference to the previous node in the linked list
        Node curr = sentinel.next; // reference to the current node in the linked list
        Node next = null; // reference to the next node in the linked list

        // While the current node is not null...
        while (curr != null) {
            // Advance the next pointer to the next node in the link
            next = curr.next;

            // Reverse the current link's next pointer to point at the previous link.
            curr.next = prev;

            // Advance the previous pointer.
            prev = curr;

            // Advance the current pointer.
            curr = next;
        }
        sentinel.next = prev;
    }

    public static void main(String[] args) {
        LinkedList<Integer> L = new LinkedList<Integer>();
        L.addFirst(20);
        L.addFirst(15);
        L.addFirst(10);
        System.out.println(L.getLast());
        L.reverse();
        System.out.println(L.getFirst());
    }
}