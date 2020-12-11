package hu.unideb.prog2;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        BasicBenchmarker bench = new BasicBenchmarker(System.out, new ListBench(), 500);
        bench.measure(ListBench::benchLinkedListFillSpeed, "LinkedList's fill performance");
        bench.measure(ListBench::benchArrayListFillSpeed, "ArrayList's fill performance (when resizing)");
        bench.measure(ListBench::benchBigArrayListFillSpeed, "ArrayList's fill performance (when NOT resizing)");
        bench.measure(ListBench::benchRandomAccessFromLinkedList, "LinkedList's random access performance");
        bench.measure(ListBench::benchRandomAccessFromArrayList, "ArrayList's random access performance");
        bench.measure(ListBench::benchRandomRemoveFromLinkedList, "LinkedList's random remove performance");
        bench.measure(ListBench::benchRandomRemoveFromArrayList, "ArrayList's random remove performance");
        bench.measure(ListBench::benchTailRemoveFromLinkedList, "LinkedList's tail remove performance");
        bench.measure(ListBench::benchTailRemoveFromArrayList, "ArrayList's tail remove performance");
        bench.measure(ListBench::benchHeadRemoveFromLinkedList, "LinkedList's head remove performance");
        bench.measure(ListBench::benchHeadRemoveFromArrayList, "ArrayList's head remove performance");
    }
}