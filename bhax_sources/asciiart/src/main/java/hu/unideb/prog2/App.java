package hu.unideb.prog2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) throw new IllegalArgumentException("Image argument required!");
        try {
            BufferedImage image = ImageIO.read(new File(args[0]));
            if (image == null) throw new IllegalArgumentException(args[0] + " is not a valid image.");
            System.out.println(ArtGen.convert(image));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
