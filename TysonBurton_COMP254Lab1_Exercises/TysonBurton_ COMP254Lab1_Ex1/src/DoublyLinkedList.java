public class DoublyLinkedList {
    private Node head;
    private Node tail;

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a node at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrev(tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    // Method to insert a node at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
    }

    // Method to insert a node in between
    public void insertInBetween(int data, int position) {
        Node newNode = new Node(data);
        if (head == null || position <= 0) {
            // Insert at the beginning if the list is empty or position is invalid
            insertAtBeginning(data);
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.getNext();
            }
            if (current != null) {
                newNode.setPrev(current);
                newNode.setNext(current.getNext());
                if (current.getNext() != null) {
                    current.getNext().setPrev(newNode);
                }
                current.setNext(newNode);
                if (current == tail) {
                    tail = newNode;
                }
            } else {
                // Insert at the end if the position is beyond the current size
                insertAtEnd(data);
            }
        }
    }

    // Method to remove a node from the end
    public void removeFromEnd() {
        if (head == null) {
            return; // List is empty
        }

        if (head == tail) {
            // Only one node in the list
            head = tail = null;
            return;
        }

        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            // If tail becomes null, set head to null as well
            head = null;
        }
    }

    // Method to remove a node from the beginning
    public void removeFromBeginning() {
        if (head == null) {
            return; // List is empty
        }

        if (head == tail) {
            // Only one node in the list
            head = tail = null;
        } else {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                // If head becomes null, set tail to null as well
                tail = null;
            }
        }
    }

    // Method to remove a node from in between
    public void removeFromInBetween(int position) {
        if (head == null || position <= 0) {
            return; // List is empty or position is invalid
        }

        if (position == 1) {
            // Remove from the beginning
            removeFromBeginning();
        } else {
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.getNext();
            }
            if (current != null && current.getNext() != null) {
                Node toRemove = current.getNext();
                current.setNext(toRemove.getNext());
                if (toRemove.getNext() != null) {
                    toRemove.getNext().setPrev(current);
                } else {
                    // If the removed node was the last node, update tail
                    tail = current;
                }
            }
        }
    }

    public static DoublyLinkedList concatenate(DoublyLinkedList L, DoublyLinkedList M) {
        //Is L null or empty?
        if (L == null || L.head == null) {
            // If true return M
            return M;
        } //Is M null or empty?
        else if (M == null || M.head == null) {
            // If true return L
            return L;
        } else {
            // Connect the end of L to the beginning of M

            //Set the tail of L to the Head of M
            L.tail.setNext(M.head);
            //Set the previous node of M's head to the tail of L
            M.head.setPrev(L.tail);

            // Update the tail of L to be the tail of M
            L.tail = M.tail;

            return L;
        }
    }

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}