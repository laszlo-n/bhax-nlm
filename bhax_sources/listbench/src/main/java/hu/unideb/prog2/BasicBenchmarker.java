package hu.unideb.prog2;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Consumer;
import java.util.stream.LongStream;

public class BasicBenchmarker implements Benchmarker {

    private final PrintStream printStream;
    private final int repeats;
    private Benchmark benchmark;

    public BasicBenchmarker(PrintStream printStream, Class<? extends Benchmark> benchmarkClass, int repeats) {
        this.printStream = printStream;
        this.repeats = repeats;
        initBenchmarkClass(benchmarkClass);
    }

    private void initBenchmarkClass(Class<? extends Benchmark> benchmarkClass) {
        try {
            this.benchmark = benchmarkClass.getConstructor().newInstance();
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            printStream.println("Failed to create a benchmarking session for the class " + benchmarkClass.getSimpleName());
            e.printStackTrace(printStream);
        }
    }

    @Override
    public void measure(Consumer<ListBench> listBenchConsumer, String msg) throws IOException {
        printStream.println("Benchmarking " + msg + "...");
        long[] times = new long[repeats];
        for (int i = 0; i < repeats; i++) {
            initBenchmarkClass(benchmark.getClass());
            long before = System.nanoTime();
            listBenchConsumer.accept((ListBench) benchmark);
            long after = System.nanoTime();
            times[i] = after - before;
        }
        printStream.println("Finished on avg in " + String.valueOf(LongStream.of(times).sum() / repeats) + " ns across " + String.valueOf(repeats) + " runs.");
    }
}
