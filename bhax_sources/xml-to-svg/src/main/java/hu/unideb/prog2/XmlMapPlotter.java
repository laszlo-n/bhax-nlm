package hu.unideb.prog2;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlMapPlotter {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        if (args.length == 2) {
            XmlReader reader = new CityReaderSaxHandler(new FileInputStream(args[0]));
            List<City> cities = reader.getCities();
            Map<String, Color> colours = new HashMap<>();
            cities.stream()
                    .map(elem -> elem.getState())
                    .forEach(elem -> {
                        colours.put(elem, new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
                    });
            MapImage image;
            if (args[1].endsWith(".svg")) {
                image = new SvgMapImage(800, 600);
            }
            else if (args[1].endsWith(".png")) {
                image = new PngMapImage(800, 600);
            }
            else { return; }
            cities.forEach(city -> {
                Color cToDrawWith = colours.get(city.getState());
                city.plot(image, cToDrawWith);
            });
            image.save(new File(args[1]));
        }
    }
}
