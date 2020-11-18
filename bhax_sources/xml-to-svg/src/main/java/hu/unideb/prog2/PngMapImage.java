package hu.unideb.prog2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class PngMapImage implements MapImage {

    BufferedImage imgbuf;
    Graphics2D img;

    public PngMapImage(int canvasWidth, int canvasHeight) {
        this.imgbuf = new BufferedImage(canvasWidth, canvasHeight, TYPE_INT_RGB);
        this.img = imgbuf.createGraphics();
    }

    @Override
    public void addPoint(double x, double y, Color c) {
        img.setColor(c);
        img.fillOval((int)x, (int)y, 2, 2);
    }

    @Override
    public void save(File file) throws IOException {
        ImageIO.write(imgbuf, "PNG", file);
    }
}
