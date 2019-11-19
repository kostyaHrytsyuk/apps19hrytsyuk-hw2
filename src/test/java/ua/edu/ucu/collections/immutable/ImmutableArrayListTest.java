package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.Stack;

import java.util.Date;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList arrayList;
    private Object[] testArr = new Object[] { 1, "Hi!", true, 2.78};
    private Object[] inArr = new Object[] {5, false, new Date(), "Hello"};

    @Before
    public void setUp() {
        this.arrayList = new ImmutableArrayList(testArr);
    }

    @Test
    public void testAdd() {
        Object o = 30;

        int expectedLength = this.arrayList.size() + 1;

        this.arrayList = this.arrayList.add(o);
        assertEquals(expectedLength, this.arrayList.size());
        assertEquals(o, this.arrayList.get(expectedLength-1));
    }

    @Test
    public void testAddByIndex() {
        Stack stack = new Stack();
        int index = 2;
        int expectedLength = this.arrayList.size() + 1;

        this.arrayList = this.arrayList.add(index, stack);

        assertEquals(expectedLength, this.arrayList.size());
        assertEquals(stack, this.arrayList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddByNegativeIndex() {
        this.arrayList.add(-5,5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddByWrongIndex() {
        this.arrayList.add(this.arrayList.size() + 42,42);
    }

    @Test
    public void testAddAll() {
        int expectedLength = this.arrayList.size() + inArr.length;

        this.arrayList = this.arrayList.addAll(inArr);

        assertEquals(expectedLength, this.arrayList.size());
        assertEquals(inArr[inArr.length-1], this.arrayList.get(expectedLength-1));
    }

    @Test
    public void testAddAllByIndex() {
        int expectedLength = this.arrayList.size() + inArr.length;
        int index = 2;
        this.arrayList = this.arrayList.addAll(index, inArr);

        assertEquals(expectedLength, this.arrayList.size());
        assertEquals(inArr[0], this.arrayList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllByNegativeIndex() {
        this.arrayList.addAll(-5, inArr);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllByWrongIndex() {
        this.arrayList.addAll(this.arrayList.size() + 5, inArr);
    }

    @Test
    public void testGetByIndex() {
        int index = 1;
        Object expectedValue = testArr[index];

        assertEquals(expectedValue, this.arrayList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetByNegativeIndex() {
        this.arrayList.get(-5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testGetByWrongIndex() {
        this.arrayList.get(this.arrayList.size());
    }

    @Test
    public void testRemoveByIndex() {
        int index = 2;
        int expectedLength = this.arrayList.size() - 1;
        Object expectedElement = testArr[index+1];

        this.arrayList = this.arrayList.remove(index);

        assertEquals(expectedLength, this.arrayList.size());
        assertEquals(expectedElement, this.arrayList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveByNegativeIndex() {
        this.arrayList.remove(-5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveByWrongIndex() {
        this.arrayList.remove(this.arrayList.size());
    }

    @Test
    public void testSet() {
        Stack stack = new Stack();
        int index = 2;
        int expectedLength = this.arrayList.size();

        this.arrayList = this.arrayList.set(index, stack);

        assertEquals(expectedLength, this.arrayList.size());
        assertEquals(stack, this.arrayList.get(index));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetByNegativeIndex() {
        this.arrayList.set(-5, null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSetByWrongIndex() { this.arrayList.set(this.arrayList.size(), null); }

    @Test
    public void testIndexOfExistingValue() {
        int index = 2;
        Object expectedValue = this.arrayList.get(index);

        assertEquals(index, this.arrayList.indexOf(expectedValue));
    }

    @Test
    public void testIndexOfMissingValue() {
        assertEquals(-1, this.arrayList.indexOf(false));
    }

    @Test
    public void testSize() {
        int expectedValue = testArr.length;
        assertEquals(expectedValue ,this.arrayList.size());
    }

    @Test
    public void testZeroSize() {
        int expectedValue = 0;
        assertEquals(expectedValue , new ImmutableArrayList().size());
    }

    @Test
    public void testClear() {
        assertTrue(this.arrayList.clear() instanceof ImmutableArrayList);
    }


    @Test
    public void testIsEmptyForFilledList() {
        assertFalse(this.arrayList.isEmpty());
    }

    @Test
    public void testIsEmptyForEmptyList() {
        assertTrue(new ImmutableArrayList().isEmpty());
    }

    @Test
    public void testToArray() {
        assertTrue(this.arrayList.toArray() instanceof Object[]);
    }

}
