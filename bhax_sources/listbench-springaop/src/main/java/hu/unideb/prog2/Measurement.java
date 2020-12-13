package hu.unideb.prog2;

import java.io.IOException;

@Service
public class Measurement {

    @NeedsMeasuring
    public void doMeasurement() {
        BasicBenchmarker bench = new BasicBenchmarker(System.out, ListBench.class, 100000);
        bench.measure(ListBench::benchLinkedListTailFillSpeed, "LinkedList's fill performance");
        bench.measure(ListBench::benchArrayListTailFillSpeed, "ArrayList's fill performance (when resizing)");
        bench.measure(ListBench::benchBigArrayListTailFillSpeed, "ArrayList's fill performance (when NOT resizing)");
        bench.measure(ListBench::benchLinkedListHeadFillSpeed, "LinkedList's head-first fill performance");
        bench.measure(ListBench::benchArrayListHeadFillSpeed, "ArrayList's head-first fill performance (when resizing)");
        bench.measure(ListBench::benchBigArrayListHeadFillSpeed, "ArrayList's head-first fill performance (when NOT resizing)");
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