import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Lawn {
    public static void main(String[] args) throws IOException {
//        String fileName = "Lawn".toLowerCase() + ".dat";
//        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\lawn.dat"));
//
//        int lines = scan.nextInt();
//        scan.nextLine();
//
//        char[][] maze = new char[scan.nextInt()][scan.nextInt()];
//        boolean[][] visited = new boolean[maze.length][maze[0].length];
//        boolean[][] correct = new boolean[maze.length][maze[0].length];
//
//        scan.nextLine();
//
//        for (int i = 0; i < maze.length; i++)
//            maze[i] = scan.nextLine().toCharArray();
//
//
//        for (int i = 0; i < maze.length; i++) {
//            for (int j = 0;  j< maze[0].length; j++) {
//                if (maze[i][j] == '*')
//                    System.out.print('*');
//                else if (CAN_REACH_START)
//                    System.out.print('B');
//                else
//                    System.out.print('s');
//            }
//            System.out.println();
//        }
//
//
//    }
//
//    public static boolean ASCII_MAZE_BASIC(int sx, int sy, int ex, int ey, char[][] maze, boolean[][] visited, boolean[][] correct) {
//        if (sx == ex && sy == ey) return true;
//        if (maze[sx][sy] == '*' || visited[sx][sy]) return false;
//        visited[sx][sy] = true;
//        if (sx != 0)
//            if (ASCII_MAZE_BASIC(sx - 1, sy, ex, ey, maze, visited, correct)) {
//                correct[sx][sy] = true;
//                return true;
//            }
//        if (sx != maze[0].length - 1)
//            if (ASCII_MAZE_BASIC(sx + 1, sy, ex, ey, maze, visited, correct)) {
//                correct[sx][sy] = true;
//                return true;
//            }
//        if (sy != 0)
//            if (ASCII_MAZE_BASIC(sx, sy - 1, ex, ey, maze, visited, correct)) {
//                correct[sx][sy] = true;
//                return true;
//            }
//        if (sy != maze.length - 1) {
//            if (ASCII_MAZE_BASIC(sx, sy + 1, ex, ey, maze, visited, correct)) {
//                correct[sx][sy] = true;
//                return true;
//            }
//        }
//        return false;
    }
}



