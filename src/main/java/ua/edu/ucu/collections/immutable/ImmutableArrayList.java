package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

import static ua.edu.ucu.collections.Checker.checkIndex;
import static ua.edu.ucu.collections.Checker.checkNull;

public final class ImmutableArrayList implements ImmutableList {
    private int length;
    private Object[] innerArray;

    public ImmutableArrayList() {this.innerArray = new Object[0];}

    private ImmutableArrayList(Object[] arr) {
        this.innerArray = Arrays.copyOf(arr, arr.length);
        this.length = this.innerArray.length;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(this.length, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(this.length, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index, this);
        checkNull(c);
        Object[] tempArr = getExtendedArray(c.length);
        if (tempArr.length - 1 - index >= 0)
            System.arraycopy(this.innerArray, index, tempArr, index + c.length, this.innerArray.length - index);
        System.arraycopy(c, 0, tempArr, index, c.length);
        return new ImmutableArrayList(tempArr);
    }

    @Override
    public Object get(int index) {
        checkIndex(index, this);
        return this.innerArray[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        return null;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.length > 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            arr[i] = this.get(i);
        }
        return arr;
    }

    private Object[] getExtendedArray(int sizeOfNewElements){
        return Arrays.copyOf(this.innerArray, this.length + sizeOfNewElements);
    }
}
