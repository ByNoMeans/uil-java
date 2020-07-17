import java.util.*;
import java.io.*;

public class PC2One {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("test.dat"));
        int tests = scan.nextInt(); scan.nextLine();
        System.out.println("tests = " + tests);
        int curr = 1;
        for (int i = 0; i < tests; i++) {
            System.out.println();
            System.out.println("Processing test #" + curr); curr++;
            for (int each = 0; each < 3; each++) {
                System.out.println("working on line" + (each + 1));
                System.out.println(scan.nextLine());
            }
        }
    }
}
