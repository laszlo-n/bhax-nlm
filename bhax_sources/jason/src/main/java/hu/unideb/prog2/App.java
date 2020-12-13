package hu.unideb.prog2;

public class App {
    public static void main(String[] args) {
        Foobar sampleObj = new Foobar(); // külön van, ha példányosításkor durranna
        System.out.println(new JSONCore().toJson(sampleObj));
    }
}