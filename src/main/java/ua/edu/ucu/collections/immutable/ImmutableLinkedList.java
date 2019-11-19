package ua.edu.ucu.collections.immutable;

import static ua.edu.ucu.collections.Checker.checkIndex;
import static ua.edu.ucu.collections.Checker.checkNull;

public class ImmutableLinkedList implements ImmutableList {
    private Node listHead;
    private Node listTail;
    private int length;

    public ImmutableLinkedList() { }

    public ImmutableLinkedList(Object[] arr) {
        ImmutableLinkedList l = addAll(arr);
        this.listHead = l.listHead;
        this.listTail = l.listTail;
        this.length = l.length;
    }

    private ImmutableLinkedList(Node head, Node tail, int length) {
        if (head != null) {
            this.listHead = head.copyOf();
            if (tail != null) {
                Node parent = this.listHead;
                for (int i = 0; i < length-1; i++) {
                    Node current = parent.getTail().copyOf();
                    setRelations(parent, current);
                    parent = current;
                }
                this.listTail = parent;
            }
        }
        this.length = length;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        checkNull(e);
        ImmutableLinkedList imList =
                new ImmutableLinkedList(this.listHead, this.listTail, this.length);
        Node node = new Node(e);
        if (imList.isEmpty()) {
            imList.listHead = node;
        } else if (imList.length == 1) {
            setRelations(imList.listHead, node);
            imList.listTail = node;
        } else {
            setRelations(this.listTail, node);
            imList.listTail = node;
        }
        imList.length++;
        return imList;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        checkIndex(index, this);
        checkNull(e);
        ImmutableLinkedList imList =
                new ImmutableLinkedList(this.listHead, this.listTail, this.length);
        Node node = new Node(e);
        Node tempNode = imList.getNode(index);

        setRelations(tempNode.getHead(), node);
        setRelations(node, tempNode);
        imList.length++;
        return imList;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        checkNull(c);
        int j = 1;
        ImmutableLinkedList imList =
                new ImmutableLinkedList(this.listHead, this.listTail, this.length);
        Node curr;
        if (imList.isEmpty()) {
            imList = imList.addFirst(c[0]);
            curr = imList.listHead;
            j = 1;
        } else if (imList.length == 1) {
            curr = imList.listHead;
            setRelations(imList.listHead, imList.listTail);
        } else {
            curr = imList.listTail;
            j = 0;
        }
        Node tempNode;

        for (int i = j; i < c.length; i++) {
            tempNode = new Node(c[i]);
            setRelations(curr, tempNode);
            curr = tempNode;
            imList.length++;
        }
        imList.listTail = curr;
        return imList;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndex(index, this);
        checkNull(c);
        ImmutableLinkedList imList = new ImmutableLinkedList(this.listHead, this.listTail, this.length);
        Node curr = imList.getNode(index).getHead();
        Node nodeTail = curr.getTail();
        Node tempNode;
        for (Object o : c) {
            tempNode = new Node(o);
            setRelations(curr, tempNode);
            curr = tempNode;
        }
        curr.setTail(nodeTail);
        imList.length += c.length;
        return imList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        checkNull(e);
        Node node = new Node(e);
        ImmutableLinkedList imList =
                new ImmutableLinkedList(this.listHead, this.listTail, this.length);

        if (imList.isEmpty()) {
            return add(e);
        }
        else {
            setRelations(node, imList.listHead);
            imList.listHead = node;
        }
        imList.length++;
        return imList;
    }

    public ImmutableLinkedList addLast(Object e) {
        checkNull(e);
        Node node = new Node(e);
        ImmutableLinkedList imList =
                new ImmutableLinkedList(this.listHead, this.listTail, this.length);

        if (imList.isEmpty()) {
            return add(e);
        } else {
            setRelations(imList.listHead, node);
            imList.listTail = node;
        }

        imList.length++;
        return imList;
    }

    public Object getFirst() {
        if (isEmpty()) {
            return null;
        } else {
            return this.listHead.getVal();
        }
    }

    public Object getLast() {
        if (isEmpty()) {
            return null;
        } else {
            return this.listTail.getVal();
        }
    }

    public ImmutableLinkedList removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            ImmutableLinkedList imList =
                    new ImmutableLinkedList(this.listHead, this.listTail, this.length);
            imList.listHead = imList.listHead.getTail();
            imList.length--;
            return imList;
        }
    }

    public ImmutableLinkedList removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            ImmutableLinkedList imList =
                    new ImmutableLinkedList(this.listHead, this.listTail, this.length);
            imList.listTail = imList.listTail.getHead();
            imList.length--;
            return imList;
        }
    }

    @Override
    public Object get(int index) {
        checkIndex(index, this);

        Node node = getNode(index);

        return node.getVal();
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index, this);
        ImmutableLinkedList imList =
                new ImmutableLinkedList(this.listHead, this.listTail, this.length);
        Node exNode = imList.getNode(index);
        Node exNodeParent = exNode.getHead();
        exNodeParent.setTail(exNode.getTail());
        imList.length--;
        return imList;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index, this);
        checkNull(e);
        ImmutableLinkedList imList =
                new ImmutableLinkedList(this.listHead, this.listTail, this.length);
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
        return this.length;
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
            while (curr != null) {
                s.append(String.format(" ,%s", curr.getVal()));
                curr = curr.getTail();
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

    private void setRelations(Node headNode, Node tailNode) {
        headNode.setTail(tailNode);
        tailNode.setHead(headNode);
    }

    private static class Node {
        private Node head;
        private Node tail;
        private Object val;

        public Node() { }

        Node(Object val) {
            this.val = val;
        }

        private Node(Node head, Node tail, Object val){
            this.head = head;
            this.tail = tail;
            this.val = val;
        }

        Node getHead() {
            return head;
        }

        void setHead(Node head) {
            this.head = head;
        }

        Node getTail() {
            return tail;
        }

        void setTail(Node tail) {
            this.tail = tail;
        }

        Object getVal() {
            return val;
        }

        void setVal(Object val) {
            this.val = val;
        }

        Node copyOf() {
            return new Node(this.head, this.tail, this.val);
        }
    }


}
