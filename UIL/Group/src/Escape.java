import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Escape {
    public static void main(String[] args) throws IOException {
        String fileName = "Escape".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File(fileName));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            scan.nextLine();
            boolean[][] wasHere = new boolean[row][col];
            boolean[][] correctPath = new boolean[row][col];
            char[][] maze = new char[row][col];
            for (int x = 0; x < row; x++) {
                char[] curr = scan.nextLine().toCharArray();
                maze[x] = curr;
            }
//            for (char[] c : maze) {
//                for (char z : c)
//                    System.out.print(z);
//                System.out.println();
//            }
            int ex = scan.nextInt();
            int ey = scan.nextInt();
            int sx = scan.nextInt();
            int sy = scan.nextInt();
            if (ASCII_MAZE_SOLVE(sx, sy, ex, ey, maze, wasHere, correctPath)) {
                System.out.println("Escaped");
            } else {
                System.out.println("Trapped");
            }

        }

    }
    public static boolean ASCII_MAZE_SOLVE(int sx, int sy, int ex, int ey, char[][] maze, boolean[][] visited, boolean[][] correct) {
        if (sx == ex && sy == ey ) return true;
        if (maze[sx][sy] == '#' || visited[sx][sy]) return false;
        visited[sx][sy] = true;

        if (sx != 0)
            if (ASCII_MAZE_SOLVE(sx - 1, sy, ex, ey, maze, visited, correct)) {
                correct[sx][sy] = true;
                return true;
            }
        if (sx != maze[0].length - 1)
            if (ASCII_MAZE_SOLVE(sx + 1, sy, ex, ey, maze, visited, correct)) {
                correct[sx][sy] = true;
                return true;
            }
        if (sy != 0)
            if (ASCII_MAZE_SOLVE(sx, sy - 1, ex, ey, maze, visited, correct)) {
                correct[sx][sy] = true;
                return true;
            }
        if (sy != maze.length - 1) {
            if (ASCII_MAZE_SOLVE(sx, sy + 1, ex, ey, maze, visited, correct)) {
                correct[sx][sy] = true;
                return true;
            }
        }
        return false;
    }
}
