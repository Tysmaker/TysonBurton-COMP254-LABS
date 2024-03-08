/*
import java.util.NoSuchElementException;
public class SinglyLinkedList
{
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
            System.out.println("Size of the queue: " + count);
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

    public static class QueueConcatenator<T> {
        public void concatenate(QueueLL<T> queue1, QueueLL<T> queue2) {
            if (!queue2.isEmpty()) {
                if (queue1.isEmpty()) {
                    queue1.first = queue2.first;
                } else {
                    queue1.last.next = queue2.first;
                }

                queue1.last = queue2.last;

                // Clear the second queue after concatenation
                queue2.first = null;
                queue2.last = null;
            }
        }
    }

    public static void main(String[] args) {
        QueueLL<Integer> queue1 = new QueueLL<>();
        QueueLL<Integer> queue2 = new QueueLL<>();

        for (int i = 1; i <= 3; i++) {
            queue1.enqueue(i);
            queue2.enqueue(i + 3);
        }

        System.out.println("Queue 1 size: ");
        queue1.size();
        System.out.println("Queue 2 size: ");
        queue2.size();

        QueueConcatenator<Integer> concatenator = new QueueConcatenator<>();
        concatenator.concatenate(queue1, queue2);

        System.out.println("Queue 1 size after concatenation: ");
        queue1.size();
        System.out.println("Queue 2 size after concatenation: ");
        queue2.size(); // Should be 0
    }

}
*/