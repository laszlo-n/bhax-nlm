package hu.unideb.prog2;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaesarCipher {

    private final int offset;
    private static final char[] lowercaseAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] uppercaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public CaesarCipher(int offset) {
        this.offset = offset;
    }

    private int findCharIndex(char[] chars, char c) {
        int out = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                out = i;
                break;
            }
        }
        return out;
    }

    public String encode(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (findCharIndex(lowercaseAlphabet, c) >= 0) {
                sb.append(lowercaseAlphabet[(findCharIndex(lowercaseAlphabet, c) + offset) % 26]);
            }
            else if (findCharIndex(uppercaseAlphabet, c) >= 0) {
                sb.append(uppercaseAlphabet[(findCharIndex(uppercaseAlphabet, c) + offset) % 26]);
            }
        }
        return sb.toString();
    }
}
