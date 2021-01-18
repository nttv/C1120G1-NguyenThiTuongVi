package day_10_dsa_stack_and_queue.bai_tap;

public class CircularQueue {
    class Node {
        public int data;
        public Node next;
    }

    private Node front;
    private Node rear;

    public void enqueue(int data) {
        Node temp = new Node();
        temp.data = data;
        if (front == null) {
            front = rear = temp;
        } else {
            rear.next = temp;
            temp.next = front;
            rear = temp;
        }
    }

    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        Node temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        } else {
            rear.next = front;
        }
        return temp.data;
    }

    public void displayQueue() {
        Node temp = front;
        while (temp.next != front) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String args[]) {
        CircularQueue q = new CircularQueue();
        q.enqueue(14);
        q.enqueue(22);
        q.enqueue(6);
        q.displayQueue();

        System.out.printf("Deleted value = % d \n", q.dequeue());
        System.out.printf("Deleted value = % d \n", q.dequeue());
        q.displayQueue();

        q.enqueue(9);
        q.enqueue(20);
        q.displayQueue();

    }
}
