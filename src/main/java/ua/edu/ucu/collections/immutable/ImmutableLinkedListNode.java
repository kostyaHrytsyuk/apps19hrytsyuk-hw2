package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedListNode {
    private ImmutableLinkedListNode head;
    private ImmutableLinkedListNode tail;
    private Object val;

    public ImmutableLinkedListNode () {}

    public ImmutableLinkedListNode (Object val) {
        this.val = val;
    }

    public ImmutableLinkedListNode (ImmutableLinkedListNode head, Object val) {
        this.head = head;
        this.val = val;
    }

    public ImmutableLinkedListNode (ImmutableLinkedListNode head, ImmutableLinkedListNode tail, Object val) {
        this.head = head;
        this.tail = tail;
        this.val = val;
    }

    public ImmutableLinkedListNode getHead() {
        return head;
    }

    public void setHead(ImmutableLinkedListNode head) {
        this.head = head;
    }

    public ImmutableLinkedListNode getTail() {
        return tail;
    }

    public void setTail(ImmutableLinkedListNode tail) {
        this.tail = tail;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}
