package hu.unideb.prog2;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class IrisCsvDatasetLoader implements DatasetLoader<Iris> {
    public IrisCsvDatasetLoader() { }

    public List<Iris> loadFile(String path) throws IOException, InputMismatchException {
        List<Iris> res = new LinkedList<>();

        try (Scanner scanner = new Scanner(new FileReader(path))) {
            scanner.useDelimiter(",|\\n");
            scanner.useLocale(Locale.ENGLISH);
            while(scanner.hasNextLine()) {
                Iris temp = new Iris();
                if (scanner.hasNextDouble()) {
                    temp.setSepalLength(scanner.nextDouble());
                    temp.setSepalWidth(scanner.nextDouble());
                    temp.setPetalLength(scanner.nextDouble());
                    temp.setPetalWidth(scanner.nextDouble());
                    temp.setIrisClass(scanner.next());
                    res.add(temp);
                }
                scanner.nextLine();
            }
        }

        return res;
    }
}
