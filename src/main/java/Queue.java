public class Queue {
    private class Node {
        Object data;
        Node next;
        public Node(Object data) {
            this.data = data;
        }
    }

    /*
    [ ] -> [ ] -> [ ]
     h             t
    */

    Node head; // The front; items are removed from here
    Node tail; // The back; items are added here

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Object o) {
        if (isEmpty()) {
            head = new Node(o);
            tail = head;
        } else {
            tail.next = new Node(o);
            tail = tail.next;
        }
    }

    public Object peek() {
        return head.data;
    }

    public Object remove(){
        Object data = head.data;
        head = head.next;
        return data;
    }
}

