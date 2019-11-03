package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.Queue;
import ua.edu.ucu.collections.Stack;

import java.util.Date;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList linkedList;
    private Object[] testArr = new Object[] { 1, "Hi!", true, 2.78};
    private Object[] inArr = new Object[] {5, false, new Date(), "Hello"};

    @Before
    public void setUp() {
        this.linkedList = new ImmutableLinkedList(testArr);
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
        int index = 2;
        int expectedLength = this.linkedList.size() + 1;

        this.linkedList = this.linkedList.add(index, stack);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(stack, this.linkedList.get(index));
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

    @Test(expected = NullPointerException.class)
    public void testAddAllWithNullValue() {
        this.linkedList.addAll(null);
    }

    @Test
    public void testAddAllByIndex() {
        int expectedLength = this.linkedList.size() + inArr.length;
        int index = 2;
        this.linkedList = this.linkedList.addAll(index, inArr);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(inArr[0], this.linkedList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllByNegativeIndex() {
        this.linkedList.addAll(-5, inArr);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllByWrongIndex() {
        this.linkedList.addAll(this.linkedList.size() + 5, inArr);
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllByWrongIndexWithNull() {
        this.linkedList.addAll(0, null);
    }

    @Test
    public void testAddFirst() {
        Queue queue = new Queue();

        int expectedLength = this.linkedList.size() + 1;

        this.linkedList = this.linkedList.addFirst(queue);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(queue, this.linkedList.getFirst());
    }

    @Test(expected = NullPointerException.class)
    public void testAddFirstWithNull() {
        this.linkedList.addFirst(null);
    }

    @Test
    public void testAddLast() {
        Queue queue = new Queue();

        int expectedLength = this.linkedList.size() + 1;

        this.linkedList = this.linkedList.addLast(queue);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(queue, this.linkedList.getLast());
    }

    @Test(expected = NullPointerException.class)
    public void testAddLastWithNull() {
        this.linkedList.addLast(null);
    }

    @Test
    public void testGetFirst() {
        Object expectedValue = testArr[0];

        assertEquals(expectedValue, this.linkedList.getFirst());
    }

    @Test
    public void testGetFirstFromEmptyList() {
        assertNull(new ImmutableLinkedList().getFirst());
    }

    @Test
    public void testGetLast() {
        Object expectedValue = testArr[testArr.length - 1];

        assertEquals(expectedValue, this.linkedList.getLast());
    }

    @Test
    public void testGetLastFromEmptyList() {
        assertNull(new ImmutableLinkedList().getLast());
    }

    @Test
    public void testRemoveFirst() {
        int expectedLength = this.linkedList.size() - 1;
        Object expectedElement = testArr[1];

        this.linkedList = this.linkedList.removeFirst();

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(expectedElement, this.linkedList.getFirst());
    }

    @Test
    public void testRemoveFirstFromEmptyList() {
        assertNull(new ImmutableLinkedList().removeFirst());
    }

    @Test
    public void testRemoveLast() {
        int expectedLength = this.linkedList.size() - 1;
        Object expectedElement = testArr[testArr.length - 2];

        this.linkedList = this.linkedList.removeLast();

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(expectedElement, this.linkedList.getLast());
    }

    @Test
    public void testRemoveLastFromEmptyList() {
        assertNull(new ImmutableLinkedList().removeLast());
    }

    @Test
    public void testGetByIndex() {
        int index = 1;
        Object expectedValue = testArr[index];

        assertEquals(expectedValue, this.linkedList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetByNegativeIndex() {
        this.linkedList.get(-5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetByWrongIndex() {
        this.linkedList.get(this.linkedList.size());
    }

    @Test
    public void testRemoveByIndex() {
        int index = 2;
        int expectedLength = this.linkedList.size() - 1;
        Object expectedElement = testArr[index+1];

        this.linkedList = this.linkedList.remove(index);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(expectedElement, this.linkedList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveByNegativeIndex() {
        this.linkedList.remove(-5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveByWrongIndex() {
        this.linkedList.remove(this.linkedList.size());
    }

    @Test
    public void set() {
        Stack stack = new Stack();
        int index = 2;
        int expectedLength = this.linkedList.size();

        this.linkedList = this.linkedList.set(index, stack);

        assertEquals(expectedLength, this.linkedList.size());
        assertEquals(stack, this.linkedList.get(index));

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetByNegativeIndex() {
        this.linkedList.set(-5, null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetByWrongIndex() { this.linkedList.set(this.linkedList.size(), null); }

    @Test(expected = NullPointerException.class)
    public void testSetByIndexWithNull() { this.linkedList.set(1, null); }

    @Test
    public void testIndexOfExistingValue() {
        int index = 2;
        Object expectedValue = this.linkedList.get(index);

        assertEquals(index, this.linkedList.indexOf(expectedValue));
    }

    @Test
    public void testIndexOfMissingValue() {
        assertEquals(-1, this.linkedList.indexOf(false));
    }

    @Test(expected = NullPointerException.class)
    public void testIndexOfWithNull() { this.linkedList.indexOf(null); }


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