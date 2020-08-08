import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Moose {
    public static void main(String[] args) throws IOException {
        String fileName = "Moose".toLowerCase() + ".dat";
        String barrettPath = "..\\past-competitions\2013-2\\SampleData\\" + fileName;
        String sidPath = "../past-competitions/2013-2/SampleData/" + fileName;
        Scanner scan = new Scanner(new File(sidPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            char[][] mat = process2DASCII(scan,10,10);
            print2DArray(mat);
            int max = 0;
            for (int r = 0; r < mat.length; r++) {
                for (int c = 0; c < mat[0].length; c++) {
                    max = Math.max(solve(r, c, 10, 10, mat),max);
                }
            }
            System.out.println(max);
        }
    }

    public static int solve(int cr, int cc, int r, int c, char[][] mat) {
        int res = 1;
        if (cr < 0 || cc < 0 || cr > r - 1 || cc > c - 1 || mat[cr][cc] != 'M')
            return 0;
        mat[cr][cc] = '#';
        res += solve(cr + 1, cc, r, c, mat)
        + solve(cr - 1, cc, r, c, mat)
                + solve(cr, cc + 1, r, c, mat)
                + solve(cr, cc - 1, r, c, mat);
        return res;
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