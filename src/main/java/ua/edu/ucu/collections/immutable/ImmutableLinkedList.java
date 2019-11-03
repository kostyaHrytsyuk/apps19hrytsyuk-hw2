package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node listHead;
    private Node listTail;
    private int length;

    public ImmutableLinkedList() {}

    private ImmutableLinkedList(Node head) {
        this.listHead = head;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        checkNull(e);
        ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
        Node newNode = new Node(e);
        newNode.setHead(imList.listTail);
        imList.listTail.setTail(newNode);
        imList.listTail = newNode;
        this.length++;
        return imList;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        checkIndex(index);
        checkNull(e);
        ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
        Node newNode = new Node(e);
        Node tempNode = imList.listHead;
        int counter = 0;
        while (counter != index) {
            tempNode = tempNode.getTail();
            counter++;
        }

        newNode.setTail(tempNode.getTail());
        newNode.setHead(tempNode);
        tempNode.setTail(newNode);
        this.length++;
        return imList;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        checkNull(c);
        int j;
        ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
        if (this.listHead == null) {
            imList.listHead.setVal(c[0]);
            imList.listTail = imList.listHead;
            j = 1;
        }
        else {
            j = 0;
        }
        Node tempNode;

        for (int i = j; i < c.length; i++) {
            tempNode = new Node(c[i]);
            tempNode.setHead(imList.listTail);
            imList.listTail.setTail(tempNode);
            imList.listTail = tempNode;
        }
        this.length += c.length;
        return imList;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndex(index);
        checkNull(c);
        ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
        Node curr = imList.getNode(index);
        Node nodeTail = curr.getTail();
        Node tempNode;
        for (Object o : c) {
            tempNode = new Node(o);
            curr.setTail(tempNode);
            curr = tempNode;
        }
        curr.setTail(nodeTail);

        return imList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return new ImmutableLinkedList();
    }

    public ImmutableLinkedList addLast(Object e) {
        return new ImmutableLinkedList();
    }

    public Object getFirst() {
        return isEmpty() ? new Object() : this.listHead.getVal();
    }

    public Object getLast() {
        return isEmpty() ? new Object() : this.listTail.getVal();
    }

    public ImmutableLinkedList removeFirst() {
        if (isEmpty()) {
            return new ImmutableLinkedList();
        } else {
            ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
            imList.listHead = imList.listHead.getTail();
            return imList;
        }
    }

    public ImmutableLinkedList removeLast() {
        if (isEmpty()) {
            return new ImmutableLinkedList();
        } else {
            ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
            imList.listTail.setHead(imList.listTail.getHead());
            return imList;
        }
    }

    @Override
    public Object get(int index) {
        checkIndex(index);

        Node node = getNode(index);

        return node.getVal();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
        Node exNode = imList.getNode(index);
        Node exNodeParent = exNode.getHead();
        exNodeParent.setTail(exNode.getTail());
        return imList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index);
        checkNull(e);
        ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead);
        imList.getNode(index).setVal(e);
        return imList;
    }

    @Override
    public int indexOf(Object e) {
        checkNull(e);
        int i = 0;
        Node current = this.listHead;
        while (i < this.length) {
            if (current.getVal().equals(e)) {
                return i;
            }
            current = current.getTail();
            i++;
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.listHead == null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.length];
        Node curr = this.listHead;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = curr.getVal();
            curr = curr.getTail();
        }

        return arr;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            Node curr = this.listHead;
            StringBuilder s = new StringBuilder(String.format("%s", curr.getVal()));
            if (this.length == 1) {
                return s.toString();
            }
            curr = curr.getTail();
            while (curr.getVal() != null) {
                s.append(String.format(" ,%s", curr.getVal()));
            }
            return s.toString();
        }
    }

    private Node getNode(int index) {
        Node tempNode = this.listHead;
        int counter = 0;
        while (counter != index) {
            tempNode = tempNode.getTail();
            counter++;
        }
        return tempNode;
    }

    private void checkNull(Object o) {
        if (o == null) {
            throw new NullPointerException("New object is null!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 && index >= this.length) {
            throw new ArrayIndexOutOfBoundsException("Index is out of array!");
        }
    }

    private class Node {
        private Node head;
        private Node tail;
        private Object val;

        public Node() {}

        public Node(Object val) {
            this.val = val;
        }

        public Node(Node head, Object val) {
            this.head = head;
            this.val = val;
        }

        public Node(Node head, Node tail, Object val) {
            this.head = head;
            this.tail = tail;
            this.val = val;
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public Object getVal() {
            return val;
        }

        public void setVal(Object val) {
            this.val = val;
        }
    }


}
