/*********************************************************************
Purpose/Description: This program implements a max-heap using an array of integers.
                    It also has a method to replace keys, called replaceKey().
Author’s Panther ID: xxxxxx
Certification:
I hereby certify that this work is my own and none of it is the work of
any other person.
********************************************************************/

package replacekey1;

/**
 *
 * @author midiel305
 */
public class ReplaceKey1 {
    
    
    
    /* [min-heap] Ex.         3
                            /  \
                           5    6
                         / \   
                        8  20
    A min-heap is a binary tree completeley filled (with the
    possible exception of the bottom level) from left to right. The key of
    of a node MUST be less than the key of it's children/s.
    
    A) 
    - Preorder traversal: The output is not sorted. Because preorder traversal 
        uses the secuence (node/root, left, right). Example, the output for the
        above heap would be: (3, 5, 8, 20, 6) which is not sorted.
    - Inorder: The output is not sorted. Because inorder traversal
        uses the secuence (left, node/root, right). Example, the output for the
        above heap would be: (8, 5, 20, 3, 6) which is not sorted.
    - Postorder: The output is not sorted. Because postorder traversal 
        uses the secuence (left, right, node/root). Example, the output for the
        above heap would be: (8, 20, 5, 6, 3) which is not sorted.
    
    B)
    - We performe a preorder traversal of the min-hep.
        - If the value of the root is smaller than "X", then we print or save
        the node, and call the method recursively for the left child and for the right child.
        - If the value of a node is equal or greater then "X", then we do not save 
        that node nor continue with recusion because the childrens must be greater by min-heap definition.
    
    - The worst case of this algorith is O(N) when all the nodes are smaller than
        the value of "X".
      
    C)
    - The replaceKey() is the last one inside the MaxHeap class. See below.
    
    */
    
/**
 * This class implements a max-heap using an array of integers.
 */
public static class MaxHeap {
      
    private int[] heap;                 // hep to hold the keys
    private int numKeys;                // number of keys in the heap
    
    /**
     * Default constructor with no-argument
     */
    public MaxHeap() {
        numKeys = 0;
        heap = new int[1];
    }
      
    /**
     * Constructor that accepts the size of the heap
     * 
     * @param size of the heap
     */
    public MaxHeap(int size) {
        numKeys = 0;
        heap = new int[size];     
    }
    
    /**
     * Constructor using an array of integers
     * 
     * @param array the keys to add to the heap
     */
    public MaxHeap(int[] array) {
        numKeys = 0;
        heap = new int[array.length];
        
        // copy the array to the heap
        for(int i = 0; i < heap.length; i++) {
            insert(array[i]);
        }
    }
      
    /**
     * Checks if the heap is empty or not.
     * 
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return numKeys == 0;
    }
      
    /**
     * Checks if the heap is full
     * 
     * @return true if full, false otherwise
     */
    public boolean isFull() {
        return numKeys == heap.length;
    }
      
    /**
     * It will insert a new element/key into the heap if there is room for it.
     * 
     * @param i the element/key to insert
     */
    public void insert(int i) {
        if(isFull()) {
            System.out.println("The heap is full, there is no room for insertion");
        } else {
            heap[numKeys++] = i;
            percolateUp(numKeys - 1);
        }
    }
      
    /**
     * Deletes the key/element at position i
     * 
     * @param i position of key to be deleted
     */
    public void delete(int i) {
        if(isEmpty()) {
            System.out.println("The heap is empty.");
        } else {
            int key = heap[i];
            heap[i] = heap[numKeys - 1];
            numKeys--;
            percolateDown(i);
            System.out.println("The key " + key + " has been deleted.");
        }
    }
    
    /**
     * Calculates the position of the parent
     * 
     * @param i position of the child
     * @return position of the parent
     */
    private int parent(int i) {
        return (i-1)/2;
    }
  
    /**
     * It arranges the keys to achieve the proper order
     * 
     * @param i the position to check for proper order
     */
    private void percolateUp(int i) {
        int temp = heap[i];
        while(i > 0 && temp > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = temp;
    }
    
    /**
     * Calculates the child's position.
     * 
     * @param i position to check
     * @param j left or right child
     * @return position of child
     */
    private int childPosition(int i, int j) {
        return (2 * i) + j;
    }
    
    /**
     *  Finds which is the greater child
     * @param i position of the parent/node
     * @return position of biggest child
     */
    private int maxChild(int i) {
        int leftChild = childPosition(i, 1);
        int rightChild = childPosition(i, 2);
      
        // Calculates which child is the biggest
        if(heap[leftChild] > heap[rightChild]) {
            return leftChild;
        } else {
            return rightChild;
        }
    }
    
    /**
     * To arrange the heap in case of deletion.
     * 
     * @param i position to check for proper order
     */
    private void percolateDown(int i) {
        int childPosition;
        int temp = heap[i];
        while(childPosition(i, 1) < numKeys) {
            childPosition = maxChild(i);
            if(temp < heap[childPosition]){
                heap[i] = heap[childPosition];
            }else {
                break;
            }
            i = childPosition;
        }
        heap[i] = temp;
    }
        
    /**
     * Returns the maximum element
     * @return max element
     */
    public int findMax() {
        if(isEmpty()) {
            System.out.println("The heap is empty.");
        }
        return heap[0];  
    }
     
    
    /**
     * Prints the entire heap.
     */
    public void print() {
        System.out.print("Heap: *** ");
        for (int i = 0; i < numKeys; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    /** C)
     * It accepts an old and a new key. It searches for the old key, if found
     * it replaces the old key with the new one and re-arranges the heap.
     * If not found, it prints an appropriate message and does not modify the
     * heap.
     * 
     * @param oldKey key to look for in the heap
     * @param newKey key to replace the old key
     */
    public void replaceKey(Integer oldKey, Integer newKey) {
        boolean found = false;
        for (int i = 0; i < numKeys; i++) {      
            if(heap[i] == oldKey) {
                heap[i] = newKey;
                percolateUp(i);
                found = true;
            }     
        }
        if(!found) {
            System.out.println("The Key " + oldKey + " does not exist in the heap.");
        }
    }   
}
    
    
    /**
     * To test the MaxHeap class
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Intance of a MaxHeap initiated with a size of 15
        MaxHeap bh;
        bh = new MaxHeap(15);
        
        // Insert the test keys
        bh.insert(99);
        bh.insert(64);
        bh.insert(42);
        bh.insert(54);
        bh.insert(32);
        bh.insert(28);
        bh.insert(6);
        bh.insert(19);
        bh.insert(7);
        bh.insert(26);
        bh.insert(4);
        
        // Print the heap
        bh.print();
        
        // Replace a key 
        bh.replaceKey(new Integer(54), new Integer(105));
        
        // Print the heap
        bh.print();
    }  
}