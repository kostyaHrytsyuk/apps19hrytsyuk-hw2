package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.DataStructure;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack implements DataStructure {
    private ImmutableLinkedList linkedList;

    public Object peek() {
        return this.linkedList.getFirst();
    }

    public Object pop() {
        Object head = peek();
        this.linkedList = this.linkedList.removeFirst();

        return head;
    }

    void push(Object e) {
        this.linkedList = this.linkedList.addFirst(e);
    }
}
