/* Invariants:
 * the last item in the array is always found at size - 1.
 * position of the next item to be inserted will be at size. 
*/
public class ArrayList {
    // Instance variables
    private int[] items;
    private int size;

    // Constructor to create an empty ArrayList
    public ArrayList() {
        items = new int[100];
        size = 0;
    }

    // Inserts an item at the end of the ArrayList
    public void addLast(int item) {
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
        items[size] = 0;
        size -= 1;
        return res;
    }
}