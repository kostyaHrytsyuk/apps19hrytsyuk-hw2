package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableList;

public class Checker {
    public static void checkNull(Object o) {
        if (o == null) {
            throw new NullPointerException("New object is null!");
        }
    }

    public static void checkIndex(int index, ImmutableList immutable) {
//        if (index < 0 || index >= immutable.size()) {
//            throw new ArrayIndexOutOfBoundsException("Index is out of array!");
//        }
        if (index < 0 || index > immutable.size()) {
            throw new ArrayIndexOutOfBoundsException("Index is out of array!");
        }
    }
}
