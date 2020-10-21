package hu.unideb.prog2;

import java.util.Arrays;

public class IntegerStorageByTheTeacher {
    private int[] storage;
    private int index = 0;

    public IntegerStorageByTheTeacher(int size) {
        this.storage = new int[size];
    }

    public IntegerStorageByTheTeacher(int[] storage) {
        this.storage = storage;
        this.index = storage.length - 1;
    }

    public void add(Integer value) {
        storage[index++] = value;
    }

    public boolean contains(Integer value) {
        return false;
    }

    public int[] sort() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerStorageByTheTeacher that = (IntegerStorageByTheTeacher) o;
        return Arrays.equals(storage, that.storage);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(storage);
    }

    @Override
    public String toString() {
        return "IntegerStorageByTheTeacher{" +
                "storage=" + Arrays.toString(storage) +
                '}';
    }
}
