package hu.unideb.prog2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;

public interface DatasetLoader<T> {
    List<T> loadFile(String path) throws IOException, InputMismatchException;
}
