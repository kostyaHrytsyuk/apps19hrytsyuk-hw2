package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckerTest {

    @Test
    public void testConstructor(){
        assertTrue(new Checker() instanceof Checker);
    }
}