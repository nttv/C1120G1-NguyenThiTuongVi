package day_9_dsa_list.bai_tap.LinkedList;

public class MyLinkedList<E> {
    private class Node {
        private Object data;
        private Node next;

        public Node() {
        }

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        Node node = new Node(element);
        if (numNodes == 0) {
            head = node;
        } else {
            if (index <= 0) {
                node.next = head;
                head = node;
            } else {
                Node temp = head;
                for (int i = 1; i < index && temp.next != null; i++) {
                    temp = temp.next;
                }
                Node holder = temp.next;
                temp.next = node;
                temp.next.next = holder;
            }
        }
        numNodes++;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(numNodes, element);
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index from 0 to " + (numNodes - 1));
        }
        Node temp = head;
        E data;
        if (index == 0) {
            data = (E) head.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            data = (E) temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return data;
    }

    public boolean remove(Object e) {
        if (head.data.equals(e)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(e)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public Object clone() {
        MyLinkedList<E> newLinkedList = new MyLinkedList<E>();
        Node temp = head;
        while (temp != null) {
            newLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return newLinkedList;
    }

    public boolean contains(E o) {
        if (indexOf(o) != -1) {
            return true;
        }
        return false;
    }

    public int indexOf(E o) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.data.equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException("Index from 0 to " + (numNodes - 1));
        } else {
            Node temp = head;
            int index = 0;
            while (index < i) {
                temp = temp.next;
                index++;
            }
            return (E) temp.data;
        }
    }

    public E getFirst() {
        return (E) head.data;
    }

    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void clear() {
        numNodes = 0;
        head = null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
