package ua.edu.ucu.collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;
    private Object[] arr;

    @Before
    public void setUp() {
        arr = new Object[] { 1, "Hi!", true, 2.78};
        stack = new Stack(arr);
    }

    @Test
    public void testPeek() {
        Object expectedValue = arr[arr.length - 1];

        assertEquals(expectedValue, stack.peek());
    }

    @Test
    public void testPeekWithEmptyStack() {
        Stack empty = new Stack();

        assertNull(empty.peek());
    }

    @Test
    public void testPop() {
        int expectedLength = stack.size() - 1;

        Object topEl = stack.pop();

        assertEquals(expectedLength, stack.size());
        assertEquals(topEl, arr[arr.length - 1]);
    }

    @Test
    public void testPopWithEmptyStack() {
        Stack empty = new Stack();

        int expectedLength = 0;
        Object topEl = empty.pop();
        assertEquals(expectedLength, empty.size());
        assertNull(topEl);
    }

    @Test
    public void testPush() {
        int expectedLength = stack.size() + 1;

        Object topEl = new Queue();

        stack.push(topEl);

        assertEquals(expectedLength, stack.size());
        assertEquals(topEl, stack.peek());
    }

    @Test
    public void testSize() {
        assertEquals(this.arr.length, this.stack.size());
    }

    @Test
    public void testSizeOnEmptyStack() {
        Stack empty = new Stack();

        assertEquals(0, empty.size());
    }
}
