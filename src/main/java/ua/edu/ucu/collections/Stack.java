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
        return this.linkedList.getLast();
    }

    public Object pop() {
        Object head = peek();
        this.linkedList = this.linkedList.removeLast();

        return head;
    }

    public void push(Object e) {
        this.linkedList = this.linkedList.addLast(e);
    }

    public int size() {
        return this.linkedList.size();
    }

}
