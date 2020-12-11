package hu.unideb.prog2;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListBench implements Benchmark {
    private final LinkedList<Integer> linkedList;
    private final ArrayList<Integer> smallArrayList;
    private final ArrayList<Integer> bigArrayList;

    public ListBench() {
        linkedList = new LinkedList<>();
        smallArrayList = new ArrayList<>();
        bigArrayList = new ArrayList<>(2000);
        benchLinkedListFillSpeed();
        benchBigArrayListFillSpeed();
    }

    public void benchLinkedListFillSpeed() {
        for (int i = 0; i < 500; i++) {
            linkedList.add(i);
        }
    }

    public void benchArrayListFillSpeed() {
        for (int i = 0; i < 500; i++) {
            smallArrayList.add(i);
        }
    }

    public void benchBigArrayListFillSpeed() {
        for (int i = 0; i < 500; i++) {
            bigArrayList.add(i);
        }
    }

    public void benchRandomAccessFromLinkedList() {
        for (int i = 0; i < 100; i++) {
            Integer temp = linkedList.get((int) (Math.random() * linkedList.size()));
        }
    }

    public void benchRandomAccessFromArrayList() {
        for (int i = 0; i < 100; i++) {
            Integer temp = bigArrayList.get((int) (Math.random() * linkedList.size()));
        }
    }

    public void benchRandomRemoveFromLinkedList() {
        for (int i = 0; i < 100; i++) {
            Integer temp = linkedList.remove((int) (Math.random() * linkedList.size()));
        }
    }

    public void benchRandomRemoveFromArrayList() {
        for (int i = 0; i < 100; i++) {
            Integer temp = bigArrayList.remove((int) (Math.random() * linkedList.size()));
        }
    }

    public void benchTailRemoveFromLinkedList() {
        for (int i = 0; i < 100; i++) {
            linkedList.removeLast();
        }
    }

    public void benchTailRemoveFromArrayList() {
        for (int i = 0; i < 100; i++) {
            bigArrayList.remove(bigArrayList.size() - 1);
        }
    }

    public void benchHeadRemoveFromLinkedList() {
        for (int i = 0; i < 100; i++) {
            linkedList.removeFirst();
        }
    }

    public void benchHeadRemoveFromArrayList() {
        for (int i = 0; i < 100; i++) {
            bigArrayList.remove(0);
        }
    }
}
