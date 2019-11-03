package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.DataStructure;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue implements DataStructure {
    private ImmutableLinkedList linkedList;

    public Queue () {
        this.linkedList = new ImmutableLinkedList();
    }

    public Queue(Object[] o) {
        this.linkedList = new ImmutableLinkedList().addAll(o);
    }

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
