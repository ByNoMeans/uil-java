import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Xorio {
    public static void main(String[] args) throws IOException {
        String fileName = "Xorio".toLowerCase() + ".dat";
        String sidPath = "../past-competitions/urmum/SampleData/" + fileName;
        String compPath = String.format("./dataSet/%s", fileName);
        Scanner scan = new Scanner(new File(compPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {

        }
    }

    public static void print2DArray(char[][] in) {
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