import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Chances {
    public static void main(String[] args) throws IOException {
        String fileName = "Chances".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File(fileName));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            double first = scan.nextDouble();
            double second = scan.nextDouble();
            System.out.printf("%.0f%n", second / 100 * first);
        }

    }
}
