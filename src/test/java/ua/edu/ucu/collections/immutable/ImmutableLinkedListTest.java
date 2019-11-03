package ua.edu.ucu.collections.immutable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList linkedList;

    @Before
    public void setUp() {
        Object[] arr = { 1, "Hi!", true, 2.78};
        this.linkedList = new ImmutableLinkedList(arr);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAdd() {
        Object o = 30;

        int expectedLength = this.linkedList.size() + 1;

        this.linkedList = this.linkedList.add(o);
        assertEquals(this.linkedList.size(), expectedLength);
    }

    @Test(expected = NullPointerException.class)
    public void testAddWithEmptyElement() {
    }

    @Test
    public void addAll() {
    }

    @Test
    public void testAddAll() {
    }

    @Test
    public void addFirst() {
    }

    @Test
    public void addLast() {
    }

    @Test
    public void getFirst() {
    }

    @Test
    public void getLast() {
    }

    @Test
    public void removeFirst() {
    }

    @Test
    public void removeLast() {
    }

    @Test
    public void get() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void set() {
    }

    @Test
    public void indexOf() {
    }

    @Test
    public void size() {
    }

    @Test
    public void clear() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void toArray() {
    }

    @Test
    public void testToString() {
    }
}