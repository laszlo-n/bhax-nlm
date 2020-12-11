package hu.unideb.prog2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Kezdd el gépelni az (ascii) üzenetet, amit le szeretnél titkosítani! " +
                "Az üzenetedet soronként a ciphertext.txt-be fogom menteni, 3-as Caesar-kódolással.");

        CaesarCipher cipher = new CaesarCipher(2);
        try (Scanner scanner = new Scanner(System.in); PrintWriter pw = new PrintWriter("ciphertext.txt")) {
            while(scanner.hasNextLine()) {
                pw.println(cipher.encode(scanner.nextLine()));
                pw.flush(); // for that soronkénti diskre írás
            }
        }
    }
}
