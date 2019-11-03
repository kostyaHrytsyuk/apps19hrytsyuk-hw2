package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private ImmutableLinkedListNode listHead;
    private ImmutableLinkedListNode listTail;
    private int listSize;

    public ImmutableLinkedList() {}

    private ImmutableLinkedList(ImmutableLinkedListNode head) {
        this.listHead = head;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        checkNull(e);
        ImmutableLinkedList newList = new ImmutableLinkedList(this.listHead);
        ImmutableLinkedListNode newNode = new ImmutableLinkedListNode(e);
        newNode.setHead(newList.listTail);
        newList.listTail.setTail(newNode);
        newList.listTail = newNode;
        return newList;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        checkIndex(index);
        checkNull(e);
        ImmutableLinkedList newList = new ImmutableLinkedList(this.listHead);
        ImmutableLinkedListNode newNode = new ImmutableLinkedListNode(e);
        ImmutableLinkedListNode tempNode = newList.listHead;
        int counter = 0;
        while (counter != index) {
            tempNode = tempNode.getTail();
            counter++;
        }

        newNode.setTail(tempNode.getTail());
        newNode.setHead(tempNode);
        tempNode.setTail(newNode);

        return newList;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        checkNull(c);
        ImmutableLinkedList newList = new ImmutableLinkedList(this.listHead);
        ImmutableLinkedListNode tempNode;

        for (int i = 0; i < c.length; i++) {
            tempNode = new ImmutableLinkedListNode(c[i]);
            tempNode.setHead(newList.listTail);
            newList.listTail.setTail(tempNode);
            newList.listTail = tempNode;
        }

        return newList;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        return null;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return new ImmutableLinkedList();
    }

    public ImmutableLinkedList addLast(Object e) {
        return new ImmutableLinkedList();
    }

    public Object getFirst() {
        return null;
    }

    public Object getLast() {
        return null;
    }

    public ImmutableLinkedList removeFirst() {
        return new ImmutableLinkedList();
    }

    public ImmutableLinkedList removeLast() {
        return new ImmutableLinkedList();
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        return null;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public ImmutableLinkedList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.listHead == null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public String toString() {
        return null;
    }

    private void checkNull(Object o) {
        if (o == null) {
            throw new NullPointerException("New object is null!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 && index >= this.listSize) {
            throw new ArrayIndexOutOfBoundsException("Index is out of array!");
        }
    }
}
