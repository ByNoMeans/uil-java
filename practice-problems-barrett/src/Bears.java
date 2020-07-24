import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Bears {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-1/SampleData/bears.dat"));
        int lines = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < lines; i++) {
            int count = 0;
            for (int j = 0; j < 10; j++) {
                System.out.println(Stream.of(scan.nextLine().split("")).filter(e -> e.equals("B")).count());
            }
            System.out.println(count);
        }
    }
}