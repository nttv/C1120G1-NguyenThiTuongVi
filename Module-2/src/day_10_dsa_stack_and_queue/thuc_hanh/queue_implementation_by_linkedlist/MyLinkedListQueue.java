package day_10_dsa_stack_and_queue.thuc_hanh.queue_implementation_by_linkedlist;

public class MyLinkedListQueue {
    class Node {
        public int key;
        public Node next;

        public Node() {
        }

        public Node(int key) {
            this.key = key;
        }
    }

    private Node head;
    private Node tail;

    public MyLinkedListQueue() {
    }

    public void enqueue(int key) {
        Node temp = new Node(key);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public Node dequeue() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return temp;
    }
}
