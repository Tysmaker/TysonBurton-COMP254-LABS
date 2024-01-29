public class Main {
    public static void main(String[] args) {
        CircularlyLinkedList originalList = new CircularlyLinkedList();
        originalList.insertAtEnd("John");
        originalList.insertAtEnd("Tim");
        originalList.insertAtEnd("Darren");

        // Cloning the Orginal List
        CircularlyLinkedList clonedList = originalList.clone();

        // Print the original list
        System.out.println("Original List:");
        originalList.display();

        // Print the cloned list
        System.out.println("Cloned List:");
        clonedList.display();
    }
}