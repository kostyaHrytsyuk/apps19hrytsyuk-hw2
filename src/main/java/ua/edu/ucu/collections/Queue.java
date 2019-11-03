package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedList;

    public Object peek() {
        return linkedList.getFirst();
    }

    public Object dequeue() {
        Object head = peek();

        this.linkedList = this.linkedList.removeFirst();

        return head;
    }

    void enqueue(Object e) {
        this.linkedList = this.linkedList.add(e);
    }
}
