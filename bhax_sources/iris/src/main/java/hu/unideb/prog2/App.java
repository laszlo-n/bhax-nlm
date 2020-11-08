package hu.unideb.prog2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Input dataset megadása kötelező!");
        }
        else {
            var irisParser = new IrisCsvDatasetLoader();
            try {
                List<Iris> irises = irisParser.loadFile(args[0]);

                // a következő szakasz undorító fertő, de mivel 20 perc van
                // éjfélig, most így marad, hogy funkcionálisan teljesítve
                // legyenek a feladatkövetelmények.
                // refaktorálni majd a következő committal fogom, ahol már
                // nem fog szorítani az időlimit

                var avgPWs = new LinkedList<Double>();
                var avgPLs = new LinkedList<Double>();
                var avgSWs = new LinkedList<Double>();
                var avgSLs = new LinkedList<Double>();
                irises.stream().map(elem -> elem.irisClass).distinct().forEach(irisClass -> {
                    avgPWs.add(irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.petalWidth)
                            .reduce(0.0, Double::sum) /
                            irises.stream().filter(elem -> elem.irisClass.equals(irisClass)).count());
                    avgPLs.add(irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.petalLength)
                            .reduce(0.0, Double::sum) /
                            irises.stream().filter(elem -> elem.irisClass.equals(irisClass)).count());
                    avgSWs.add(irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.sepalWidth)
                            .reduce(0.0, Double::sum)  /
                            irises.stream().filter(elem -> elem.irisClass.equals(irisClass)).count());
                    avgSLs.add(irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.sepalLength)
                            .reduce(0.0, Double::sum)  /
                            irises.stream().filter(elem -> elem.irisClass.equals(irisClass)).count());

                });

                var medPWs = new LinkedList<Double>();
                var medPLs = new LinkedList<Double>();
                var medSWs = new LinkedList<Double>();
                var medSLs = new LinkedList<Double>();
                irises.stream().map(elem -> elem.irisClass).distinct().forEach(irisClass -> {
                    Double[] pwidths = irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.petalWidth)
                            .sorted()
                            .toArray(Double[]::new);

                    Double[] plens = irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.petalLength)
                            .sorted()
                            .toArray(Double[]::new);

                    Double[] swidths = irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.sepalWidth)
                            .sorted()
                            .toArray(Double[]::new);

                    Double[] slens = irises.stream()
                            .filter(elem -> elem.irisClass.equals(irisClass))
                            .map(elem -> elem.sepalLength)
                            .sorted()
                            .toArray(Double[]::new);

                    medPWs.add(pwidths.length % 2 == 0 ? (pwidths[pwidths.length / 2] + pwidths[pwidths.length / 2 - 1]) / 2 : pwidths[pwidths.length / 2]);
                    medPLs.add(pwidths.length % 2 == 0 ? (pwidths[pwidths.length / 2] + pwidths[pwidths.length / 2 - 1]) / 2 : pwidths[pwidths.length / 2]);
                    medSWs.add(pwidths.length % 2 == 0 ? (pwidths[pwidths.length / 2] + pwidths[pwidths.length / 2 - 1]) / 2 : pwidths[pwidths.length / 2]);
                    medSLs.add(pwidths.length % 2 == 0 ? (pwidths[pwidths.length / 2] + pwidths[pwidths.length / 2 - 1]) / 2 : pwidths[pwidths.length / 2]);
                });
                irises.stream().map(elem -> elem.irisClass).distinct().forEach(irisClass -> {
                    // System.out.println("Fajta neve: {0}", irisClass);
                });
            }
            catch (IOException e) {
                System.out.println("Az input fájlt nem lehetett betölteni!");
                e.printStackTrace();
            }
            catch (InputMismatchException e) {
                System.out.println("Az input fájlban az adat nem megfelelően volt formázva!");
                e.printStackTrace();
            }
        }
    }
}
