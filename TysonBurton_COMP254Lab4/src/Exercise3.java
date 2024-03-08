import java.util.NoSuchElementException;

public class Exercise3
{

    //Concatenate Class/Method
    public static class queueConcatenator<T>
    {
        //Created a concatenate method with 2 peramaters for Queue1 and Queue2
        public void concatenate(QueueLL<T> queue1, QueueLL<T> queue2)
        {
            //Check if the que is not empty
            if (!queue2.isEmpty()) {

                //If the queue1 is empty
                if (queue1.isEmpty())
                {
                    //Then we set the first element of the queue to the first element of the second queue
                    queue1.first = queue2.first;
                }
                else
                {
                    //set the last element of the Queue1 to the first element of Queue2
                    queue1.last.next = queue2.first;
                }
               // Set the last element of the Queue1 to te last element of queue2
                queue1.last = queue2.last;

                // Clear the second queue after concatenating
                queue2.first = null;
                queue2.last = null;
            }
        }
    }

    //Output
    public static void main(String[] args)
    {
        QueueLL<Integer> queue1 = new QueueLL<>();
        QueueLL<Integer> queue2 = new QueueLL<>();

        for (int i = 1; i <= 3; i++)
        {
            //adding elements at the end of queue1
            queue1.enqueue(i);
            //adding elements at the end of queue2 but we +3 so that we add 4,5,6
            queue2.enqueue(i + 3);
        }

        System.out.print("Queue1 size: ");
        queue1.size();

        System.out.print("Queue2 size: ");
        queue2.size();

        System.out.println("=================");

        queueConcatenator<Integer> concatenator = new queueConcatenator<>();
        concatenator.concatenate(queue1, queue2);

        System.out.print("Queue1 size after concatenation: ");
        queue1.size();
        System.out.print("Queue2 size after concatenation: ");
        queue2.size();
    }





    //Example Code QUEUE Linked List

    public static class Node<T> {
        T item;
        Node<T> next;
    }

    public static class QueueLL<T> {
        private Node<T> first, last;

        public boolean isEmpty() {
            return first == null;
        }

        public void enqueue(T item) {
            Node<T> oldLast = last;
            last = new Node<>();
            last.item = item;
            last.next = null;

            if (isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            T item = first.item;
            first = first.next;

            if (isEmpty()) {
                last = null;
            }

            return item;
        }

        public void size() {
            int count = 0;
            Node<T> current = first;
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println(count);
        }

        public void print() {
            Node<T> current = first;
            while (current != null) {
                System.out.print(current.item + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}