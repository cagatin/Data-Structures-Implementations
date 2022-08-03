/* Invariants:
 * the last item in the array is always found at size - 1.
 * position of the next item to be inserted will be at size. 
*/
public class ArrayList {
    // Instance variables
    private int[] items;
    private int size;
    private int MAX_CAPACITY = 100;

    // Constructor to create an empty ArrayList
    public ArrayList() {
        items = new int[MAX_CAPACITY];
        size = 0;
    }

    // Method to to resize the underlying array
    private void resize() {
        int newMaxCapacity = MAX_CAPACITY * 2;
        int[] newArr = new int[newMaxCapacity];
        System.arraycopy(items, 0, newArr, 0, size);
        MAX_CAPACITY = newMaxCapacity;
        items = newArr;
    }

    // Inserts an item at the end of the ArrayList
    public void addLast(int item) {
        if (size == MAX_CAPACITY) {
            resize();
        }
        items[size] = item;
        size += 1;
    }

    // Returns the item at the end of the ArrayList
    public int getLast() {
        return items[size - 1];
    }

    // Retrieve the ith item in the ArrayList (Zero indexed)
    public int get(int i) {
        return items[i];
    }

    // Returns the number of items in the ArrayList
    public int size() {
        return size;
    }

    // Deletes the last item in the list and returns the deleted item
    public int removeLast() {
        int res = getLast();
        size -= 1;
        return res;
    }
}