package hu.unideb.prog2;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public interface MapImage {
    void addPoint(double x, double y, Color c);
    void save(File file) throws IOException;
}
