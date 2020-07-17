import java.util.*;
import java.io.*;
public class PC2Three {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("elevator.dat"));
        int tests = scan.nextInt(); scan.nextLine();
        for (int i = 0; i < tests; i++) {
            int sum = 0; int people = 0;
            for (String h : scan.nextLine().split(" ")) {
                sum += Integer.parseInt(h);
                if (sum <= 2000) { people++; }
            }
            System.out.println(people);
        }
    }
}
