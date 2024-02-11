public class SinglyLinkedList {
    private Node head;
    private Node tail;

    // Constructor
    public SinglyLinkedList() {
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
                newNode.setNext(current.getNext());
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

        Node current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }

        current.setNext(null);
        tail = current;
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
        }
    }

    public void swapNodes(int position1, int position2) {
        //If Both Positions are the same return and do nothing
        if (position1 == position2) {

            return;
        }

        //Assigns node1 to position1
        Node node1 = getNodeAtPosition(position1);
        //Assigns Node2 to position2
        Node node2 = getNodeAtPosition(position2);

        //Were Checking if both nodes are found (i.e not null)
        if (node1 != null && node2 != null) {

            //Were going to store node1 data in temp
            int temp = node1.getData();

            //We set node1 data to node2 data
            node1.setData(node2.getData());

            //We set the data of node2 back to the data of node1 because temp is = node1 data
            node2.setData(temp);
        }
    }
    private Node getNodeAtPosition(int position) {
        if (position <= 0 || head == null) {
            //The position is Invalid or the list is empty
            return null;
        }

        //Set the current = to head
        Node current = head;
        //Iterate through the list of nodes
        for (int i = 1; i < position && current != null; i++) {
            //Move to the next node in the list
            current = current.getNext();
        }
        //returns the node at the current position
        return current;
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
                current.setNext(current.getNext().getNext());
                if (current.getNext() == null) {
                    // If the removed node was the last node, update tail
                    tail = current;
                }
            }
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
