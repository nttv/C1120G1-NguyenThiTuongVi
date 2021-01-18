package day_10_dsa_stack_and_queue.thuc_hanh.stack_implementation_by_linkedlist;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class MyGenericStack<T> {
    public List<T> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    public void push(T element) {
        stack.add(0, element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(0);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
