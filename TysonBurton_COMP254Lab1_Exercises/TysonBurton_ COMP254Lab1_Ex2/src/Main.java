public class Main {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();

        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);

        System.out.println("Before Swap:");
        linkedList.display(); // Output: 10 20 30

        linkedList.swapNodes(1, 3); //Calls SwapNodes Method and swaps at position (1 && 3)

        System.out.println("After Swap:");
        linkedList.display(); // Output: 30 20 10

    }
}// Output: 10 20 30
