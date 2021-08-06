import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {

    private static final int ASCII_EXTENDED = 256;

    public static void encode() {
        char[] sequence = new char[ASCII_EXTENDED];
        for (int i = 0; i < ASCII_EXTENDED; i++) {
            sequence[i] = (char) i;
        }

        while (!BinaryStdIn.isEmpty()) {
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
        char[] sequence = new char[ASCII_EXTENDED];
        for (int i = 0; i < ASCII_EXTENDED; i++) {
            sequence[i] = (char) i;
        }

        while (!BinaryStdIn.isEmpty()) {
            int index = BinaryStdIn.readInt(8);
            BinaryStdOut.write(sequence[index], 8);

            char temp = sequence[index];
            for (int i = index; i > 0; i--) {
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