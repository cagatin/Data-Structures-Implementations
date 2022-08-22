/* Invariants:
 * the last item in the array is always found at size - 1.
 * position of the next item to be inserted will be at size. 
*/
public class ArrayList<Item> {
    // Instance variables
    private Item[] items;
    private int size;
    private int INIT_CAPACITY = 100;

    // Constructor to create an empty ArrayList
    public ArrayList() {
        items = (Item[]) new Object[INIT_CAPACITY];
        size = 0;
    }

    // Method to to resize the underlying array
    private void resize(int capacity) {
        Item[] newArr = (Item[]) new Object[capacity * 2];
        System.arraycopy(items, 0, newArr, 0, size);
        items = newArr;
    }

    // Inserts an item at the end of the ArrayList
    public void addLast(Item item) {
        if (size == items.length) {
            resize(items.length);
        }
        items[size] = item;
        size += 1;
    }

    // Returns the item at the end of the ArrayList
    public Item getLast() {
        return items[size - 1];
    }

    // Retrieve the ith item in the ArrayList (Zero indexed)
    public Item get(int i) {
        return items[i];
    }

    // Returns the number of items in the ArrayList
    public int size() {
        return size;
    }

    // Deletes the last item in the list and returns the deleted item
    public Item removeLast() {
        Item res = getLast();
        items[size - 1] = null; // change deleted value to null
        size -= 1;
        return res;
    }
}