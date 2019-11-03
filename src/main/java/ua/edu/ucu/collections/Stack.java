package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.DataStructure;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack implements DataStructure {
    private ImmutableLinkedList linkedList;

    public Stack() {
        this.linkedList = new ImmutableLinkedList();
    }

    public Stack(Object[] o) {
        this.linkedList = new ImmutableLinkedList(o);
    }

    public Object peek() {
        return this.linkedList.getFirst();
    }

    public Object pop() {
        Object head = peek();
        this.linkedList = this.linkedList.removeFirst();

        return head;
    }

    public void push(Object e) {
        this.linkedList = this.linkedList.addFirst(e);
    }

    public int size() {
        return this.linkedList.size();
    }

    public String print() {
        return this.linkedList.toString();
    }
}
