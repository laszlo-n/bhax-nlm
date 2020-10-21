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
        if (!sorted) {
            for (int i = 0; i < lastRealIndex; i++) {
                for (int j = 1; j <= lastRealIndex; j++) {
                    // növekvő sorrendet kényszerít ki
                    if (intStore[j] > intStore[i]) {
                        // csere
                        intStore[i] += intStore[j];
                        intStore[j] = intStore[i] - intStore[j];
                        intStore[i] -= intStore[j];
                    }
                }
            }
            this.sorted = true;
        }
        return intStore.clone();
    }

    public boolean contains(int val) {
        // rendezzük az array-t
        this.sort();

        // a határelemekeet és a középpontot beállítjuk
        int L = 0;
        int R = lastRealIndex;
        int M = (R + L) / 2;

        // lecsekkoljuk a határokat
        if (R < 0 ) return false;
        if (intStore[L] == val || intStore[R] == val) return true;
        if (L == R) return false;

        // amíg a midpoint nem egyezik a keresettel, vagy
        // amíg a két szélső elem nem egymás melletti
        while (intStore[M] != val || Math.max(L, R) - Math.min(L, R) > 1) {
            if (val < intStore[M]) R = M;
            else L = M;
            M = (R + L) / 2;
        }

        // bármelyik condition miatt állt is le a ciklus, ez
        // a kifejezés a helyes választ fogja most itt adni
        return intStore[M] == val;
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
