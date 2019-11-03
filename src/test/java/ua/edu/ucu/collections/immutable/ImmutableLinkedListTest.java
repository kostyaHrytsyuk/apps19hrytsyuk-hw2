package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.Stack;

import java.util.Date;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList linkedList;
    private Object[] inArr = new Object[] {5, false, new Date(), "Hello"};

    @Before
    public void setUp() {
        this.linkedList = new ImmutableLinkedList(new Object[] { 1, "Hi!", true, 2.78});
    }

    @Test
    public void testAdd() {
        Object o = 30;

        int expectedLength = this.linkedList.size() + 1;

        this.linkedList = this.linkedList.add(o);
        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(o, this.linkedList.getLast());
    }

    @Test(expected = NullPointerException.class)
    public void testAddWithEmptyElement() {
        this.linkedList.add(null);
    }

    @Test
    public void testAddByIndex() {
        Stack stack = new Stack();

        int expectedLength = this.linkedList.size() + 1;

        this.linkedList = this.linkedList.add(2, stack);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(stack, this.linkedList.get(2));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddByNegativeIndex() {
        this.linkedList.add(-5,null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddByWrongIndex() {
        this.linkedList.add(this.linkedList.size() + 42,null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddByIndexWithNullValue() {
        this.linkedList.add(0,null);
    }

    @Test
    public void testAddAll() {
        int expectedLength = this.linkedList.size() + inArr.length;

        this.linkedList = this.linkedList.addAll(inArr);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(inArr[inArr.length-1], this.linkedList.getLast());
    }

    @Test
    public void testAddAllByIndex() {
        int expectedLength = this.linkedList.size() + inArr.length;
        int index = 2;
        this.linkedList = this.linkedList.addAll(index, inArr);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(inArr[0], this.linkedList.get(index));
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllWithNullValue() {
        this.linkedList.addAll(null);
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