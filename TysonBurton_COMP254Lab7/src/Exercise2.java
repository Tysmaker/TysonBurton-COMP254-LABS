import java.util.LinkedList;
import java.util.Queue;
public class Exercise2
{
    public static class BottomUpMergeSort
    {

        public static void bottomUpMergeSort(int[] array)
        {
            int n = array.length;

            Queue<Queue<Integer>> queueOfQueues = new LinkedList<>();

            // Place each element of the array in its own queue
            for (int num : array)
            {
                Queue<Integer> q = new LinkedList<>();
                q.add(num);
                queueOfQueues.add(q);
            }

            while (queueOfQueues.size() > 1)
            {
                Queue<Integer> q1 = queueOfQueues.poll();
                Queue<Integer> q2 = queueOfQueues.poll();
                Queue<Integer> mergedQueue = mergeQueues(q1, q2);
                queueOfQueues.add(mergedQueue);
            }

            //Copy the sorted elements from the final queue back to the arraY
            Queue<Integer> sortedQueue = queueOfQueues.poll();

            int i = 0;

            while (!sortedQueue.isEmpty())
            {
                array[i++] = sortedQueue.poll();
            }
        }

        public static Queue<Integer> mergeQueues(Queue<Integer> q1, Queue<Integer> q2)
        {
            Queue<Integer> mergedQueue = new LinkedList<>();

            while (!q1.isEmpty() && !q2.isEmpty())
            {
                if (q1.peek() < q2.peek())
                {
                    mergedQueue.add(q1.poll());
                }
                else
                {
                    mergedQueue.add(q2.poll());
                }
            }
            while (!q1.isEmpty())
            {
                mergedQueue.add(q1.poll());
            }
            while (!q2.isEmpty())
            {
                mergedQueue.add(q2.poll());
            }
            return mergedQueue;
        }
    }
    public static void main(String[] args)
    {
        int[] array = {4, 2, 7, 1, 3, 6, 5};

        BottomUpMergeSort.bottomUpMergeSort(array);

        System.out.println("Sorted Array:");

        for (int num : array)
        {
            System.out.print(num + " ");
        }
    }
}
