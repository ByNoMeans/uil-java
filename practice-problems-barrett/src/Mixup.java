import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Mixup {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("..\\past-competitions\\UTCS_UIL_2010\\SampleData\\" + "mixup.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            ArrayList<String> in = new ArrayList<>(List.of(scan.nextLine().split("\\s")));
            for (int j = 0; j < in.size(); j++) {
                for (int z = in.get(j).length() - 1; z >= 0; z--) {
                    System.out.print(in.get(j).charAt(z));
                }
                if (j == in.size() - 1)
                    System.out.println();
                else
                    System.out.print(" ");
            }
        }
        ArrayList<Integer> in = new ArrayList<>(List.of(1, 2, 3, 34));
        System.out.println(in.stream().mapToInt(a -> a).sum());
    }

    public static void print2DCharArray(char[][] in) {
        IntStream.range(0, in.length).forEach(e -> System.out.println(Arrays.toString(in[e]).replaceAll("[\\s,\\[\\]]", "")));
    }

    public static char[][] process2DASCII(Scanner scan, int length, int width) {
        char[][] out = new char[length][width];
        for (int i = 0; i < length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < width; j++)
                out[i][j] = line.charAt(j);
        }
        return out;
    }
}