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
            System.out.println(end==0?"STUCK": (end+" MOVES" ));
        }

    }

    public static int solve(int sR, int sC, int sF, int shots, char[][][] maze) {
        if (sR < 0 || sC < 0 || sF < 0 || sR > maze.length - 1 || sC > maze[0].length - 1 || sF > maze[0][0].length - 1 || maze[sR][sC][sF] == '#' || (maze[sR][sC][sF] == '*' && shots < 1))
            return 0;
        char current = maze[sR][sC][sF];
        int distance = 0;
        if (maze[sR][sC][sF] != 'E') {
            maze[sR][sC][sF] = '#';
            if (current == '*') {
                int bestPath = solveHelper(sR, sC, sF, shots - 1, maze);
                distance += Math.max(bestPath, 1);
            } else if (current == '.') {
                int bestPath = solveHelper(sR, sC, sF, shots, maze);
                distance += Math.max(bestPath, 1);
            } else {
                int bestPath = solveHelper(sR, sC, sF, shots, maze);
                distance += Math.max(bestPath, 0);
            }
        }
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



