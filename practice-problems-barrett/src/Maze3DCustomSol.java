import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Maze3DCustomSol {
    static char[][][] maze;

    public static void main(String[] args) throws IOException {
        String fileName = "Maze3DCustomSol".toLowerCase() + ".dat";
        String barrettPath = "..\\past-competitions\\2013-1\\SampleData\\" + fileName;
        String sidPath = "../past-competitions/2013-1/SampleData/" + fileName;
        Scanner scan = new Scanner(new File("..\\past-competitions\\2013-2\\SampleData\\" + "maze3d.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            int row = scan.nextInt();
            int col = scan.nextInt();
            int floor = scan.nextInt();
            maze = new char[row][col][floor];
            scan.nextLine();
            int sR = 0, sC = 0, sF = 0;
            for (int j = 0; j < floor; j++) {
                for (int k = 0; k < row; k++) {
                    String line = scan.nextLine();
                    for (int l = 0; l < col; l++) {
                        maze[k][l][j] = line.charAt(l);
                        if (line.charAt(l) == 'S') {
                            sR = k;
                            sC = l;
                            sF = j;
                        }
                    }
                }
            }
            int end = solve(sR, sC, sF, 3, maze);
            System.out.println(end == 0 ? "STUCK" : (end + " MOVES"));
        }

    }

    public static int solve(int sR, int sC, int sF, int shots, char[][][] maze) {
        // Fail
        if (sR < 0 || sC < 0 || sF < 0 || sR > maze.length - 1 || sC > maze[0].length - 1 || sF > maze[0][0].length - 1 || maze[sR][sC][sF] == '#')
            return 0;
        // Success
        if (maze[sR][sC][sF] == 'E')
            return 1;
        char current = maze[sR][sC][sF];
        int distance = 0;
        // Mark visited
        maze[sR][sC][sF] = '#';
        // Only increment distance by 1 + bestPath if the bestPath is actually existing; else
        // Don't increment, effectively returning 0 (failure)
        if (current == '*') {
            // Skips if no shots, effectively returning 0
            if (shots > 0) {
                int bestPath = solveHelper(sR, sC, sF, shots - 1, maze);
                distance += bestPath > 0 ? bestPath + 1 : 0;
            }
        } else if (current == '.') {
            int bestPath = solveHelper(sR, sC, sF, shots, maze);
            distance += bestPath > 0 ? bestPath + 1 : 0;
        } else {
            // At start (don't increment the distance traveled; at the start
            // you've travelled nowhere)
            int bestPath = solveHelper(sR, sC, sF, shots, maze);
            distance += Math.max(bestPath, 0);
        }
        // Preserve maze
        maze[sR][sC][sF] = current;
        return distance;
    }

    public static int solveHelper(int sR, int sC, int sF, int shots, char[][][] maze) {
        return List.of(
                solve(sR + 1, sC, sF, shots, maze),
                solve(sR - 1, sC, sF, shots, maze),
                solve(sR, sC + 1, sF, shots, maze),
                solve(sR, sC - 1, sF, shots, maze),
                solve(sR, sC, sF + 1, shots, maze),
                solve(sR, sC, sF - 1, shots, maze)
        ).stream().filter(e -> e > 0).min(Integer::compare).orElse(0);
    }

}



