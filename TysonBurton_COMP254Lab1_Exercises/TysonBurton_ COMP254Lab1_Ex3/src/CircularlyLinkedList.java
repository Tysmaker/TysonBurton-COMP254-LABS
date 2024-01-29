public class CircularlyLinkedList {

        private Node head;
        private Node tail;
        private int size;

        /**
         * Default constructor
         */
        public CircularlyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        /**
         * Method to add a node to the beginning of the circular linked list
         * @param head
         */
        public void setHead(Node head) {
            this.head = head;
        }

        /**
         * Method to add a node to the end of the circular linked list
         * @param tail
         */
        public void setTail(Node tail) {
            this.tail = tail;
        }

        /**
         * Method to get the head of the circular linked list
         * @return head
         */
        public Node getHead() {
            return this.head;
        }

        /**
         * Method to get the tail of the circular linked list
         * @return tail
         */
        public Node getTail() {
            return this.tail;
        }

        /**
         * Method to insert a node at the beginning of the circular linked list
         * @param data
         */
        public void insertAtBeginning(String data) {
            Node newNode = new Node(data);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
                this.tail.setNext(head);
            } else {
                newNode.setNext(head);
                this.head = newNode;
                this.tail.setNext(head);
            }
            this.size++;
        }

        /**
         * Method to insert a node at the end of the circular linked list
         * @param data
         */
        public void insertAtEnd(String data) {
            Node newNode = new Node(data);
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
                this.tail.setNext(head);
            } else {
                this.tail.setNext(newNode);
                this.tail = newNode;
                this.tail.setNext(head);
            }
            this.size++;
        }

        /**
         * Method to insert a node at a given position in the circular linked list
         * @param data
         * @param position
         */
        public void insertAtPosition(String data, int position) {
            Node newNode = new Node(data);
            if (this.head == null || position <= 0) {
                insertAtBeginning(data);
            } else {
                Node current = this.head;
                for (int i = 1; i < position - 1 && current != this.tail; i++) {
                    current = current.getNext();
                }
                if (current != tail) {
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                } else {
                    insertAtEnd(data);
                }
            }
            this.size++;
        }

        public void deleteAtBeginning() {
            if (this.head == null) {
                System.out.println("List is empty");
            } else {
                this.head = this.head.getNext();
                this.tail.setNext(this.head);
                this.size--;
            }
        }

        public void deleteAtEnd() {
            if (this.head == null) {
                System.out.println("List is empty");
            } else {
                Node current = this.head;
                while (current.getNext() != this.tail) {
                    current = current.getNext();
                }
                this.tail = current;
                this.tail.setNext(this.head);
                size--;
            }
        }

        public void deleteAtPosition(int position) {
            if (this.head == null) {
                System.out.println("List is empty");
            } else {
                Node current = this.head;
                for (int i = 1; i < position - 1 && current != this.tail; i++) {
                    current = current.getNext();
                }
                if (current != this.tail) {
                    current.setNext(current.getNext().getNext());
                } else {
                    deleteAtEnd();
                }
                size--;
            }
        }

    public CircularlyLinkedList clone() {
        //Created new list called CloneList to store the nodes
        CircularlyLinkedList clonedList = new CircularlyLinkedList();

        //Check if the head for original list is empty
        if (this.head != null) {
            //Set the originalCurrent = to the head of the original list to start with
            Node originalCurrent = this.head;

            // Cloning the head of the orignal list
            Node clonedHead = new Node(originalCurrent.getData());
            //Setting the head of the cloned list to the clonedHead
            clonedList.setHead(clonedHead);
            //Set the clonedTail = to the cloned Head
            Node clonedTail = clonedHead;

            // Clone the rest of the nodes and link them
            while (originalCurrent.getNext() != this.head) {

                //Move to the next node in the original list
                originalCurrent = originalCurrent.getNext();
                //Create a newNode of the current node
                Node newNode = new Node(originalCurrent.getData());
                //Move the newNode to the clonedList and put it where the tail is
                clonedTail.setNext(newNode);

                //Point clonedTail to the newNode
                clonedTail = newNode;
            }

            // Set the tail of the clonedList to the clonedTail
            clonedList.setTail(clonedTail);
            //link the clonedTail to the clonedHead of the list
            clonedTail.setNext(clonedHead);

            //Set the size of the cloned list
            clonedList.size = this.size;
        }

        return clonedList;
    }


    /**
         * Method to display the circular linked list
         */
        public void display() {
            if (this.head == null) {
                System.out.println("List is empty");
            } else {
                Node current = this.head;
                System.out.print(this.size + " ");
                do {
                    System.out.print(current.getData() + " ");
                    current = current.getNext();
                } while (current != this.head);
                System.out.println();
            }
        }
    }

