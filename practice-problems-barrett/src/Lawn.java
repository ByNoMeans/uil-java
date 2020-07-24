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

            mow(maze, 0, 0);

            for (char[] chars : maze) {
                for (int k = 0; k < maze[0].length; k++) {
                    if (chars[k] == '.')
                        System.out.print('s');
                    else
                        System.out.print(chars[k]);
                }
                System.out.println();
            }
            System.out.println();
        }


    }

    public static void mow(char[][] in, int row, int col) {
        if (row < 0 || col < 0 || row + 3 > in.length || col + 3 > in[0].length)
            return;

        boolean newPlaceToMow = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (in[row + i][col + j] == '*') {
                    newPlaceToMow = false;
                    break;
                } else if (in[row + i][col + j] == '.')
                    newPlaceToMow = true;
            }
        }

        if (newPlaceToMow) {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    in[row + i][col + j] = 'B';

            mow(in, row - 1, col);
            mow(in, row, col - 1);
            mow(in, row + 1, col);
            mow(in, row, col + 1);

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

    public static void print2DCharArray(char[][] in) {
        IntStream.range(0, in.length).forEach(e -> System.out.println(Arrays.toString(in[e]).replaceAll("[\\s,\\[\\]]", "")));
    }

}



