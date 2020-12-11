package hu.unideb.prog2;

import java.io.IOException;
import java.util.function.Consumer;

@FunctionalInterface
public interface Benchmarker {
    void measure(Consumer<ListBench> listBenchConsumer, String msg) throws IOException;
}
