import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.util.Scanner;

    //This solves Blast problem given in CS_LASA_DB\UIL\Past_Comps
    public class Blast {
        public static void main(String[] args) throws Throwable {
            Scanner scan = new Scanner(new File("blast.dat"));
            //INCLUDE LENGTH AND HEIGHT AS INPUT PARAMS
            int startR = 0; int startC = 0;int endR = 0; int endC = 0;
            boolean[][] wasHere = new boolean[10][10];
            boolean[][] correctPath = new boolean[10][10];
            char[][] maze = new char[10][10];
            for (int x = 0; x < 10; x++) {
                char[] curr = scan.nextLine().toCharArray();
                maze[x] = curr;
                for (int i = 0; i < curr.length; i++) {
                    if (curr[i] == ('S')) {
                        startR = x;
                        startC = i;
                    } else if (curr[i] == ('E')) {
                        endR = x;
                        endC = i;
                    }
                }
            }

            int energy = scan.nextInt();
            if(ASCII_MAZE_SOLVE(startR, startC, endR, endC, maze, wasHere, correctPath, energy))
                System.out.println("Escaped!");
            else
                System.out.println("Impossible!");
        }

        public static boolean ASCII_MAZE_SOLVE(int sx, int sy, int ex, int ey, char[][] maze, boolean[][] visited, boolean[][] correct, int energy) {
            if (sx == ex && sy == ey && energy >= 0) return true;
            if (maze[sx][sy] == 'X' || visited[sx][sy] || energy <= 0) return false;
            visited[sx][sy] = true;

            if (maze[sx][sy] == '.') energy--;
            if (maze[sx][sy] == '*') energy-=5;
            if (sx != 0)
                if (ASCII_MAZE_SOLVE(sx - 1, sy, ex, ey, maze, visited, correct, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sx != maze[0].length - 1)
                if (ASCII_MAZE_SOLVE(sx + 1, sy, ex, ey, maze, visited, correct, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sy != 0)
                if (ASCII_MAZE_SOLVE(sx, sy - 1, ex, ey, maze, visited, correct, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sy != maze.length - 1) {
                if (ASCII_MAZE_SOLVE(sx, sy + 1, ex, ey, maze, visited, correct, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            }
            return false;
        }
    }

