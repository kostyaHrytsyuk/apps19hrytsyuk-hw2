package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    ImmutableLinkedList linkedList;

    public Object peek() {
        return linkedList.getFirst();
    }
}
