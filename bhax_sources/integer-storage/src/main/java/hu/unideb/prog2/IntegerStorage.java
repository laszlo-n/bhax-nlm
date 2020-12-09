package hu.unideb.prog2;

import java.util.Arrays;
import java.util.Objects;

public class IntegerStorage {
    private boolean sorted = true;
    private int[] intStore;
    private int lastRealIndex = -1; // index of the last real element

    public int[] getIntStore() {
        return intStore;
    }

    public boolean isSorted() {
        return sorted;
    }

    public IntegerStorage(int n) {
        // rákérdezni, hogy érdemes-e minden értéket a konstruktorokban megadni
        intStore = new int[n];
    }

    public IntegerStorage(int[] arr) {
        intStore = arr.clone();
        sorted = false;
        lastRealIndex = arr.length - 1;
    }

    public void add(int val) {
        // ha még fér
        if (lastRealIndex < intStore.length - 1) {
            intStore[lastRealIndex + 1] = val;
            lastRealIndex++;
            sorted = false;
        }

        else throw new ArrayIndexOutOfBoundsException();
    }

    public int[] sort() {
        boolean swapped = false;
        int rightLimit = lastRealIndex;
        do {
            swapped = false;
            for (int i = 0; i < rightLimit; i++) {
                if (intStore[i] > intStore[i + 1]) {
                    int temp = intStore[i];
                    intStore[i] = intStore[i + 1];
                    intStore[i + 1] = temp;
                    swapped = true;
                }
            }
            rightLimit--;
        } while(swapped);
        return intStore.clone();
    }

    public boolean contains(int val) {
        // rendezzük az array-t
        this.sort();

        // a határelemekeet és a középpontot beállítjuk
        int leftSearchBoundary = 0;
        int rightSearchBoundary = lastRealIndex;
        int searchedRegionCenter = (rightSearchBoundary + leftSearchBoundary) / 2;

        // lecsekkoljuk a határokat
        if (rightSearchBoundary < 0 ) return false;
        if (intStore[leftSearchBoundary] == val || intStore[rightSearchBoundary] == val) return true;
        if (leftSearchBoundary == rightSearchBoundary) return false;

        // amíg a midpoint nem egyezik a keresettel, vagy
        // amíg a két szélső elem nem egymás melletti
        while (intStore[searchedRegionCenter] != val || Math.max(leftSearchBoundary, rightSearchBoundary) - Math.min(leftSearchBoundary, rightSearchBoundary) > 1) {
            if (val < intStore[searchedRegionCenter]) rightSearchBoundary = searchedRegionCenter;
            else leftSearchBoundary = searchedRegionCenter;
            searchedRegionCenter = (rightSearchBoundary + leftSearchBoundary) / 2;
        }

        // bármelyik condition miatt állt is le a ciklus, ez
        // a kifejezés a helyes választ fogja most itt adni
        return intStore[searchedRegionCenter] == val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerStorage that = (IntegerStorage) o;
        return sorted == that.sorted &&
                lastRealIndex == that.lastRealIndex &&
                Arrays.equals(intStore, that.intStore);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sorted, lastRealIndex);
        result = 31 * result + Arrays.hashCode(intStore);
        return result;
    }

    @Override
    public String toString() {
        return "IntegerStorage{" +
                "sorted=" + sorted +
                ", intStore=" + Arrays.toString(intStore) +
                ", lastRealIndex=" + lastRealIndex +
                '}';
    }
}
