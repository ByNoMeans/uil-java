import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Squares {
    public static void main(String[] args) throws IOException {
        String fileName = "Squares".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\squares.dat"));
        while (scan.hasNext()) {
            int lines = scan.nextInt();
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < lines; j++)
                    System.out.print(Math.min(lines - j - 1, Math.min(lines - i - 1, Math.min(i, j))) % 2 == 0 ? '*' : ' ');
                System.out.println();
            }
        }
    }
}