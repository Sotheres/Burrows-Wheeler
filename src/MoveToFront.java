import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    public static void encode() {
        char[] sequence = new char[256];
        for (int i = 0; i < 256; i++) {
            sequence[i] = (char) i;
        }

        while(!BinaryStdIn.isEmpty()) {
            char ch = BinaryStdIn.readChar();
            int charIndex = 0;
            for (int i = 0; i < sequence.length; i++) {
                if (sequence[i] == ch) {
                    charIndex = i;
                    break;
                }
            }
            BinaryStdOut.write(charIndex, 8);

            for (int i = charIndex; i > 0; i--) {
                sequence[i] = sequence[i - 1];
            }
            sequence[0] = ch;
        }
        BinaryStdOut.close();
    }

    public static void decode() {
        char[] sequence = new char[256];
        for (int i = 0; i < 256; i++) {
            sequence[i] = (char) i;
        }

        while(!BinaryStdIn.isEmpty()) {
            int ch = BinaryStdIn.readChar();
            BinaryStdOut.write(sequence[ch], 8);

            char temp = sequence[ch];
            for (int i = ch; i > 0; i++) {
                sequence[i] = sequence[i - 1];
            }
            sequence[0] = temp;
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if (args[0].equals("-")) {
            encode();
        } else if (args[0].equals("+")) {
            decode();
        }
    }
}