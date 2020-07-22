import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Squares {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-1/SampleData/";
        Scanner scan = new Scanner(new File(fileName+ "Squares".toLowerCase() + ".dat"));

        while (scan.hasNext()) {
            int r = scan.nextInt();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++)
                    System.out.print(Math.min(r - j - 1, Math.min(r - i - 1, Math.min(i,j))) % 2 == 0 ? '*' : ' ');
                System.out.println();
            }
            System.out.println();
        }
    }
}
