# replave-key-1

Problem #1:

(a) Consider a binary min-heap. We have a method that print the keys as encountered in a preorder traversal. Is the output sorted? Justify your answer. Attempt the same question for inorder and postorder traversal.

(b) Propose an efficient algorithm (only pseudocode) to find all nodes less than some value X in a binary min-heap. Analyze its complexity.

(c) Write (in Java) a method replaceKey in the MaxHeap class with the following signature:

public void replaceKey(Integer oldKey, Integer newKey)

The method will replace the first occurrence of oldKey with the newKey, and restore the Max-Heap property after the change. If the oldKey does not exist in the heap, the method prints an appropriate message and returns without changing the heap.

Example: Suppose our binary heap object (bh) has the following keys: *** 99 64 42 54 32 28 6 19 7 26 4

Then the method call: bh.replaceKey (new Integer(54), new Integer(105)

should change the keys to: *** 105 99 42 64 32 28 6 19 7 26 4

Note: You can assume that the methods perlocateUp and perlocateDown are already implemented in your MaxHeap class.
