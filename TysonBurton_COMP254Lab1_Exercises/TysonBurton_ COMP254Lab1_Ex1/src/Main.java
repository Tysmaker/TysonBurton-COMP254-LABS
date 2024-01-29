public class Main {
    public static void main(String[] args) {

        DoublyLinkedList list1 = new DoublyLinkedList();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(3);

        DoublyLinkedList list2 = new DoublyLinkedList();
        list2.insertAtEnd(4);
        list2.insertAtEnd(5);
        list2.insertAtEnd(6);

        //Print list 1
        System.out.println("List 1:");
        list1.display();

        //Print list 2
        System.out.println("List 2:");
        list2.display();

        //Combines both lists
        DoublyLinkedList concatenatedList = DoublyLinkedList.concatenate(list1, list2);

        //Print this List1 && list2 Concatenated
        System.out.println("Concatenated List:");
        concatenatedList.display();
    }
}

