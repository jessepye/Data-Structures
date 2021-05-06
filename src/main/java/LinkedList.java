class Node {
    private Object value;
    private Node next;

    public Object getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Object value) {
        this.value = value;
    }
}


public class LinkedList {

    Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public LinkedList() {

    }

    public LinkedList(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Object newVal) {
        if (head == null) {
            head = new Node(newVal);
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node(newVal));
        }
    }

    public void addFirst(Object newVal) {
        if (head == null) {
            head = new Node(newVal);
        } else {
            Node newNode = new Node(newVal);
            newNode.setNext(head);
            head = newNode;
        }

    }

    public void addLast(Object newVal) {
        add(newVal);
    }

    public void remove (Object valToBeRemoved) {
        if (head.getValue() == valToBeRemoved) {
            head = head.getNext();
        } else {
            for(Node currentNode = head; currentNode.getNext() != null; currentNode = currentNode.getNext()) {
                if (currentNode.getNext().getValue() == valToBeRemoved) {
                    currentNode.setNext(currentNode.getNext().getNext());
                    break;
                }
            }
        }
    }

    public Object getFirst() {
        if (head == null) return null;
        return head.getValue();
    }

    public Object getLast() {
        if (head == null) return null;
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public Object get(int i) throws IndexOutOfBoundsException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index must be above 0");
        }
        if (head == null) {
            throw new IndexOutOfBoundsException("Index of 0 out of bounds for empty list");
        }
        Node currentNode = head;
        for (int nodeCount = 0; nodeCount < i; nodeCount++){
            // We want to go to the next node, so check if it exists first:
            if(currentNode.getNext() == null) {
                throw new IndexOutOfBoundsException("Index of " + i + " is greater than last index: " + nodeCount);
            }
            currentNode = currentNode.getNext();
        }

        return currentNode.getValue();
    }

    public int contains(Object o) {
        int nodeCount = 0;
        for(Node n = head; n != null; n = n.getNext()) {
            if (n.getValue() == o) return nodeCount;
            nodeCount++;
        }
        return -1;
    }

    public void delete(Object o) {
        if (head == null) return;
        if (head.getValue() == o) {
            head = head.getNext();
        } else {
            for (Node n = head; n.getNext() != null; n = n.getNext()) {
                if (n.getNext().getValue() == o) {
                    n.setNext(n.getNext().getNext());
                    break;
                }
            }
        }
    }

    public void delete(int i) throws IndexOutOfBoundsException{
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index must be above 0");
        }
        if (head == null) {
            throw new IndexOutOfBoundsException("Index of 0 out of bounds for empty list");
        }
        if (i == 0) {
            head = head.getNext();
            return;
        }
        Node currentNode = head;
        int nodeCount;
        for (nodeCount = 0; nodeCount < i - 1; nodeCount++){
            // We want to go to the next node, so check if it exists first:
            if(currentNode.getNext() == null) {
                throw new IndexOutOfBoundsException("Index of " + i + " is greater than last index: " + nodeCount);
            }
            currentNode = currentNode.getNext();
        }

        if(currentNode.getNext() == null) {
            throw new IndexOutOfBoundsException("Index of " + i + " is greater than last index: " + nodeCount);
        }

        currentNode.setNext(currentNode.getNext().getNext());

    }

}
