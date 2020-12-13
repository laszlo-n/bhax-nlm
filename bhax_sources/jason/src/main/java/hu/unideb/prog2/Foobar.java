package hu.unideb.prog2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foobar {
    int szam = 3;
    float lebego = 3.14f;
    String sampletext = "árvíztűrő tükörfúrógép";
    List<String> bevásárlólista = List.of("alma", "körte");
    Set<Object> hardcore = Stream.of(3, 3.14d, "lorem ipsum", null)
            .collect(Collectors.toCollection(HashSet::new));
    Map<Integer, String> veszett = Map.of(314, "asd");
    HashMap<Object, List<String>> tulveszett;
    double[] dubli = { 3.14d, 5.23d };

    // nasty test case, még durvább mint a kiadott unit teszt (meg mint a börtön)
    public Foobar() {
        tulveszett = new HashMap<>();
        tulveszett.put(null, List.of("teszt", "szöveg"));
        tulveszett.put("foobar", List.of("veszett", "egy", "teszt"));
    }
}
