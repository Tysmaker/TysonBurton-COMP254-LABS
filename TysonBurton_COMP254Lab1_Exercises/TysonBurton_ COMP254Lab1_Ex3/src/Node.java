public class Node {
    private String data;
    private Node next;

    // Default Constructor - Instantiate a new Node with no data and no reference
    public Node() { }

    // Overloaded Constructor - Instantiate a new Node with data and no reference
    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    // Overloaded Constructor - Instantiate a new Node with data and a reference
    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Accessor Methods
    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    // Mutator Methods
    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return String.valueOf(this.data);
    }
}

