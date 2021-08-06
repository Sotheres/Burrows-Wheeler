import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import java.util.ArrayList;

public class BurrowsWheeler {

    public static void transform() {
        StringBuilder input = new StringBuilder();
        while (!BinaryStdIn.isEmpty()) {
            char ch = BinaryStdIn.readChar();
            input.append(ch);
        }

        CircularSuffixArray csa = new CircularSuffixArray(input.toString());
        int first = 0;
        for (int i = 0; i < csa.length(); i++) {
            if (csa.index(i) == 0) {
                first = i;
            }
        }
        BinaryStdOut.write(first);

        for (int i = 0; i < csa.length(); i++) {
            BinaryStdOut.write(input.charAt((csa.index(i) + csa.length() - 1) % csa.length()));
        }
        BinaryStdOut.close();
    }

    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        ArrayList<Character> input = new ArrayList<>();

        while (!BinaryStdIn.isEmpty()) {
            char ch = BinaryStdIn.readChar();
            input.add(ch);
        }

        int N = input.size();
        int[] count = new int[257];

        for (int i = 0; i < N; i++) {
            count[input.get(i) + 1]++;
        }
        for (int r = 0; r < 256; r++) {
            count[r + 1] += count[r];
        }
        char[] sortedInput = new char[input.size()];
        int[] next = new int[input.size()];
        for (int i = 0; i < N; i++) {
            int pos = count[input.get(i)]++;
            sortedInput[pos] = input.get(i);
            next[pos] = i;
        }

        int outputInd = first;
        for (int i = 0; i < input.size(); i++) {
            BinaryStdOut.write(sortedInput[outputInd]);
            outputInd = next[outputInd];
        }
        BinaryStdOut.close();
    }

    public static void main(String[] args) {
        if (args[0].equals("-")) {
            transform();
        } else if (args[0].equals("+")) {
            inverseTransform();
        }
    }
}
