import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Lawn {
    public static void main(String[] args) throws IOException {
        String fileName = "Lawn".toLowerCase() + ".dat";
        String barrettPath = "..\\past-competitions\\2013-1\\SampleData\\" + fileName;
        String sidPath = "../past-competitions/2013-1/SampleData/" + fileName;
        Scanner scan = new Scanner(new File(barrettPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            char[][] maze = process2DASCII(scan, scan.nextInt(), scan.nextInt());
            print2DArray(maze);
        }


    }
    public static char[][] process2DASCII(Scanner scan, int length, int width) {
        scan.nextLine();
        char[][] out = new char[length][width];
        for (int i = 0; i < length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < width; j++)
                out[i][j] = line.charAt(j);
        }
        return out;
    }

    public static void print2DArray(char[][] in) {
        IntStream.range(0, in.length).forEach(e -> System.out.println(Arrays.toString(in[e]).replaceAll("[\\s,\\[\\]]", "")));
    }

}



