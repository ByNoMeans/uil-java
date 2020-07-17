import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Diya {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("diya.dat"));

        while (scan.hasNext()) {

            int current = scan.nextInt();
            int[][] out = new int[current][current];

            int insertNum = 1; int currX = 0; int currY = 0; int currentLength = current;


            for (int i = 0; i < Math.ceil(current/2.0); i++) {

                for (int j = 0; j < currentLength; j++) {
                    out[currX][currY] = insertNum;
                    insertNum++; currY++;
                }

                currY--;
                currentLength--;
                currX++;

                for (int j = 0; j < currentLength; j++) {
                    out[currX][currY] = insertNum;
                    insertNum++; currX++;
                }

                currX--;
                currY--;

                for (int j = 0; j < currentLength; j++) {
                    out[currX][currY] = insertNum;
                    insertNum++; currY--;
                }

                currY++;
                currX--;
                currentLength--;

                for (int k = 0; k < currentLength; k++) {
                    out[currX][currY] = insertNum;
                    insertNum++; currX--;
                }

                currX++;
                currY++;

            }
            printArrayFormatted(out, current);
            System.out.println("=====");
        }
    }

    static void printArrayFormatted(int[][] twoD, int length) {
        int len = String.valueOf(length * length).length();
        String indent = "          ";

        for (int[] r : twoD) {
            for (int z : r) {
                System.out.print(z + " " + indent.substring(0, len - String.valueOf(z).length()));
            }
            System.out.println();
        }
    }
}
