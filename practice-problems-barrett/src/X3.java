import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class X3 {
    public static void main(String[] args) throws IOException {
        String fileName = "X3".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\x3.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            String out = "";
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = scan.nextInt();
            for (int j = -100; j < 101; j++) {
                if (a * Math.pow(j, 3) + b*Math.pow(j, 2) + c * j + d == 0)
                    out += j + " ";
            }
            System.out.println(out.isEmpty() ? "NO INTEGER SOLUTION" : out);
        }

    }
}



