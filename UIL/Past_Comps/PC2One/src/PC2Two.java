import java.util.*;
import java.io.*;

public class PC2Two {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("test2.dat"));
        int tests = scan.nextInt(); scan.nextLine();
        System.out.println("tests = " + tests);
        int curr = 1;
        for (int i = 0; i < tests; i++) {
            System.out.println();
            System.out.println("Processing test #" + curr); curr++;
            for (int each = 0; each < 3; each++) {
                System.out.println("working on line" + (each + 1));
                if (each == 0) {
                    System.out.print("backwards = ");
                    String[] arr = scan.nextLine().split(" ");
                    for (int j = arr.length-1; j >=0; j--) { System.out.print(arr[j] + " "); }
                    System.out.println();
                } else if (each == 1) {
                    int sum = 0; String two = scan.nextLine();
                    String[] arr1 = two.split(" ");
                    for (String h : arr1) { sum += Integer.parseInt(h); }
                    System.out.println("sum = " + sum);
                } else {
                    double sum = 0; String two = scan.nextLine();
                    String[] arr1 = two.split(" ");
                    for (String h : arr1) { sum += Double.parseDouble(h); }
                    System.out.print("sum = "); System.out.format("%.3f", sum); System.out.println();
                }
            }
        }
    }
}
