package hu.unideb.prog2;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.function.Consumer;
import java.util.stream.LongStream;

public class BasicBenchmarker implements Benchmarker {

    private final PrintStream printStream;
    private final Benchmark benchmark;
    private final int repeats;

    public BasicBenchmarker(PrintStream printStream, Benchmark benchmark, int repeats) {
        this.printStream = printStream;
        this.benchmark = benchmark;
        this.repeats = repeats;
    }

    @Override
    public void measure(Consumer<ListBench> listBenchConsumer, String msg) throws IOException {
        printStream.println("Benchmarking " + msg + "...");
        long[] times = new long[repeats];
        for (int i = 0; i < repeats; i++) {
            long before = System.currentTimeMillis();
            listBenchConsumer.accept((ListBench) benchmark);
            long after = System.currentTimeMillis();
            times[i] = after - before;
        }
        printStream.println("Finished on avg in " + String.valueOf(LongStream.of(times).sum() / repeats) + " ms across " + String.valueOf(repeats) + " runs.");
    }
}
