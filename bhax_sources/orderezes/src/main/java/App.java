import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static <T extends Comparable> List<T> createOrderedList(Collection<T> collection) {
        return collection.stream().sorted().collect(Collectors.toList());
    }

    private static class NonComparableClass {
        String filler;

        public NonComparableClass(String filler) {
            this.filler = filler;
        }
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(-19, 7, -4, 0, 82, 31);
        List<Integer> actualOutput = createOrderedList(input);

        System.out.println(actualOutput.toString());

        List<NonComparableClass> input2 = Arrays.asList(new NonComparableClass("foo"), new NonComparableClass("bar"));
        // List<NonComparableClass> failingOutput = createOrderedList(input2); // won't compile, syntax error
    }
}
