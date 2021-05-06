public class Stack {

    private class Node {
        Object data;
        Node next;
        public Node(Object data) {
            this.data = data;
        }
    }

    /*
    [ ] -> [ ] -> [ ]
     h
    */
    Node head; // Elements are both added (pushed) and removed (popped) from here

    public boolean isEmpty() { return head == null; }

    public Object peek() {
        return head.data;
    }

    public void push(Object o) {
        if (isEmpty()) {
            head = new Node(o);
        } else {
            Node newNode = new Node(o);
            newNode.next = head;
            head = newNode;
        }

    }

    public Object pop() {
        Object data = head.data;
        head = head.next;
        return data;
    }
}
