import java.util.Arrays;

public class CircularSuffixArray {

    private final int length;
    private final int[] index;

    public CircularSuffixArray(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Argument to constructor is null");
        }

        length = s.length();
        String[] suffixes = new String[length];
        for (int i = 0; i < length; i++) {
            suffixes[i] = s.substring(i, length) + s.substring(0, i);
        }

        String[] sortedSuf = new String[length];
        for (int i = 0; i < length; i++) {
            sortedSuf[i] = suffixes[i];
        }
        Arrays.sort(sortedSuf);

        index = new int[length];
        for (int i = 0; i < length; i++) {
            index[Arrays.binarySearch(sortedSuf, suffixes[i])] = i;
        }
    }

    public int length() {
        return length;
    }

    public int index(int i) {
        if (i < 0 || i >= length) {
            throw new IllegalArgumentException("Illegal index");
        }
        return index[i];
    }

    public static void main(String[] args) {
        CircularSuffixArray csa = new CircularSuffixArray("ABRACADABRA!");
        System.out.println("csa.length() = " + csa.length());

        System.out.println("index[i]: ");
        for (int i = 0; i < csa.length(); i++) {
            System.out.println(csa.index(i));
        }
    }
}
