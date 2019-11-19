package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

import ua.edu.ucu.collections.Checker;

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
        Checker.checkIndex(index, this);
        Checker.checkNull(c);
        Object[] tempArr = getExtendedArray(c.length);
        if (tempArr.length - 1 - index >= 0)
            System.arraycopy(this.innerArray, index, tempArr, index + c.length, this.innerArray.length - index);
        System.arraycopy(c, 0, tempArr, index, c.length);
        return new ImmutableArrayList(tempArr);
    }

    @Override
    public Object get(int index) {
        Checker.checkIndex(index, this);
        return this.innerArray[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        Checker.checkIndex(index, this, false);
        Object[] tempArr = new Object[this.length-1];
        System.arraycopy(this.innerArray,0, tempArr,0, index);
        System.arraycopy(this.innerArray, index+1, tempArr, index, this.length - index - 1);
        return new ImmutableArrayList(tempArr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        Checker.checkIndex(index, this, false);
        Object[] tempArr = Arrays.copyOf(this.innerArray, this.length);
        tempArr[index] = e;
        return new ImmutableArrayList(tempArr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.length; i++) {
            if (this.innerArray[i].equals(e)) {
                return i;
            }
        }
        return -1;
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
