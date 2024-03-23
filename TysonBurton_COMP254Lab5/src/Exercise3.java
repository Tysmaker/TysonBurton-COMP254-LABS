import java.util.ArrayList;

public class Exercise3 {
//Runtime O(n)
    public static class HeapPriorityQueue<T extends Comparable<T>>
    {
        private ArrayList<T> heap;

        // Constructor to initialize an empty heap
        public HeapPriorityQueue()
        {
            heap = new ArrayList<>();
        }

        // Inserts an element into the heap
        public void insert(T element)
        {
            heap.add(element);
            // Perform upheap operation to maintain heap property
            upHeap(heap.size() - 1);
        }

        // Recursive operation using upHeap method
        private void upHeap(int index)
        {
            // Base case for root has been reached
            if (index == 0) return;

            // Calculate parent's index
            int parentIndex = (index - 1) / 2;

            if (heap.get(parentIndex).compareTo(heap.get(index)) > 0)
            {
                // If parent's priority is greater than the current element, swap them
                swap(parentIndex, index);
                // Recur on the parent's index
                upHeap(parentIndex);
            }
        }

        // Removes and returns the smallest element from the heap
        public T removeMin()
        {
            if (heap.isEmpty()) throw new IllegalStateException("Priority queue is empty");

            // Remove the root element (smallest element)
            T minElement = heap.remove(0);

            // Restore heap property
            if (!heap.isEmpty()) {
                heap.add(0, heap.remove(heap.size() - 1));
                downHeap(0);
            }

            return minElement;
        }

        // Recursive operation using downHeap method
        private void downHeap(int index)
        {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallest = index;

            // Compare with left child
            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = leftChildIndex;
            }

            // Compare with right child
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(smallest)) < 0) {
                smallest = rightChildIndex;
            }

            // If the smallest element is not the root, swap and continue down
            if (smallest != index) {
                swap(index, smallest);
                downHeap(smallest);
            }
        }

        // Swaps elements at given indices
        private void swap(int i, int j)
        {
            T temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    public static void main(String[] args)
    {
        HeapPriorityQueue<Integer> pq = new HeapPriorityQueue<>();

        // Inserting elements into the priority queue
        pq.insert(5);
        pq.insert(3);
        pq.insert(8);
        pq.insert(1);
        pq.insert(10);

        // Print the elements in the priority queue
        System.out.println("Elements in the priority queue:");

        while (!pq.heap.isEmpty())
        {
            System.out.print(pq.removeMin() + " "); // Remove the smallest element
        }
        System.out.println();
    }
}