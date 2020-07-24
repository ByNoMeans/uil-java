import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Moose {
    public static void main(String[] args) throws IOException {
        String fileName = "Moose".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Desktop\\Github\\uil-java\\past-competitions\\2013-2\\SampleData\\moose.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            char[][] mooseMaze = new char[10][10];
            for (int j = 0; j < 10; j++) {
                String line = scan.nextLine();
                for (int k = 0; k < 10; k++)
                    mooseMaze[j][k] = line.charAt(k);
            }

            int max = 0;

            for (int j = 0; j < mooseMaze.length; j++)
                for (int k = 0; k < mooseMaze[0].length; k++)
                    max = Math.max(max, mooseRecursion(mooseMaze, j, k));
            System.out.println(max);

        }

    }

    private static int mooseRecursion(char[][] mooseMaze, int r, int c) {
        if (r > 9 || r < 0 || c < 0 || c > 9 || mooseMaze[r][c] != 'M')
            return 0;
        mooseMaze[r][c] = ' ';
        return 1 + mooseRecursion(mooseMaze, r - 1,c) +
                   mooseRecursion(mooseMaze, r, c - 1) +
                   mooseRecursion(mooseMaze, r + 1, c) +
                   mooseRecursion(mooseMaze, r, c + 1);
    }
}



