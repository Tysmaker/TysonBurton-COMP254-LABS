public class Node {
    private int data; // int data for Node
    private Node next; // Reference to next Node

    // Constructors
    public Node() { }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Getters and Setters
    public int getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    // toString method
    public String toString() {
        return String.valueOf(this.data);
    }

    // equals method
    public boolean equals(Node node) {
        return this.data == node.getData();
    }
}
