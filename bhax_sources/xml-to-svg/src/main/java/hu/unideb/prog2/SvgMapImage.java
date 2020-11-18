package hu.unideb.prog2;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SvgMapImage implements MapImage {

    SVGGraphics2D svgGenerator;

    public SvgMapImage(int canvasWidth, int canvasHeight) {
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "https://www.w3.org/2000/svg";
        Document document = domImpl.createDocument(svgNS, "svg", null);
        svgGenerator = new SVGGraphics2D(document);
        svgGenerator.setSVGCanvasSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    public void addPoint(double x, double y, Color c) {
        svgGenerator.setColor(c);
        svgGenerator.fillOval((int)x, (int)y, 2, 2);

    }

    @Override
    public void save(File file) throws IOException {
        svgGenerator.stream(file.getAbsolutePath());
    }
}
