import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BurrowsWheeler {

    public static void transform() {
        StringBuilder input = new StringBuilder();
        while(!BinaryStdIn.isEmpty()) {
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

        while(!BinaryStdIn.isEmpty()) {
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
        for (int i = 0; i < N; i++) {
            sortedInput[count[input.get(i)]++] = input.get(i);
        }

        int[] next = new int[input.size()];
        for (int i = 0; i < sortedInput.length; i++) {
            next[i] = input.indexOf(sortedInput[i]);
            input.set(next[i], null);
        }

        int outputInd = first;
        for (int i = 0; i < input.size(); i++) {
            BinaryStdOut.write(sortedInput[outputInd]);
            outputInd = next[outputInd];
        }
        BinaryStdOut.close();
    }

    private static StringBuilder transformFix(String input) {
        CircularSuffixArray csa = new CircularSuffixArray(input);
        int first = 0;
        for (int i = 0; i < csa.length(); i++) {
            if (csa.index(i) == 0) {
                first = i;
            }
        }

        StringBuilder output = new StringBuilder();
        output.append(first);
        for (int i = 0; i < csa.length(); i++) {
            output.append(input.charAt((csa.index(i) + csa.length() - 1) % csa.length()));
        }
        return output;
    }

    private static StringBuilder inverseTransformFix(StringBuilder input) {
        int first = input.charAt(0) - '0';

        char[] sortedInput = new char[input.length() - 1];
        for (int i = 0; i < input.length() - 1; i++) {
            sortedInput[i] = input.charAt(i + 1);
        }

        Arrays.sort(sortedInput);
        int[] next = new int[sortedInput.length];
        for (int i = 0; i < sortedInput.length; i++) {
            next[i] = input.indexOf("" + sortedInput[i]) - 1;
            input.setCharAt(next[i] + 1, '0');
        }

        StringBuilder output = new StringBuilder();
        int outCharInd = first;
        for (int i = 0; i < sortedInput.length; i++) {
            output.append(sortedInput[outCharInd]);
            outCharInd = next[outCharInd];
        }

        return output;
    }

    public static void main(String[] args) {
        ArrayList<Character> input = new ArrayList<>();
        input.add('A');
        input.add('R');
        input.add('D');
        input.add('!');
        input.add('R');
        input.add('C');
        input.add('A');
        input.add('A');
        input.add('A');
        input.add('A');
        input.add('B');
        input.add('B');

        int N = input.size();
        int[] count = new int[257];

        for (int i = 0; i < N; i++) {
            count[input.get(i) + 1]++;
        }
        for (int r = 0; r < 256; r++) {
            count[r + 1] += count[r];
        }
        char[] sortedInput = new char[input.size()];
        for (int i = 0; i < N; i++) {
            sortedInput[count[input.get(i)]++] = input.get(i);
        }

        for (char c : sortedInput) {
            System.out.println(c);
        }
    }
}
