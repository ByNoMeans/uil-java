import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Thirteen {
    public static void main(String[] args) throws IOException {
        String fileName = "Thirteen".toLowerCase() + ".dat";
        String barrettPath = "..\\past-competitions\\2013-2\\SampleData\\thirteen.dat";
        String sidPath = "../past-competitions/2013-1/SampleData/" + fileName;
        Scanner scan = new Scanner(new File(barrettPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            char[][] maze = process2DASCII(scan, 10, 10);
            System.out.println(solve(maze, 0, 0, 0));
        }

    }

    public static int solve(char[][] maze, int r, int c, int jewelCount) {
        if (r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || maze[r][c] == '#')
            return Integer.MAX_VALUE;
        if (maze[r][c] == 'E')
            return jewelCount == 13 ? 0 : Integer.MAX_VALUE;
        if (maze[r][c] == '*')
            jewelCount++;

        char curr = maze[r][c];
        maze[r][c] = '#';

        int depth = List.of
                (
                        solve(maze, r - 1, c, jewelCount),
                        solve(maze, r + 1, c, jewelCount),
                        solve(maze, r, c + 1, jewelCount),
                        solve(maze, r, c - 1, jewelCount)
                ).stream().min(Integer::compare).orElseThrow();

        maze[r][c] = curr;

        return depth == Integer.MAX_VALUE ? Integer.MAX_VALUE : depth + 1;

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



