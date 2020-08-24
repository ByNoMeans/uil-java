import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Practical {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(new File("..\\past-competitions\\UTCS_UIL_2010\\SampleData\\" + "practical.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            int next = scan.nextInt();
            scan.nextLine();
            List<Integer> factors = findFactors(next);
            System.out.println(isPractical(next, factors) ? "PRACTICAL" : "NOT PRACTICAL");
        }

    }

    public static List<Integer> findFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= num - 1; i++) {
            if (num % i == 0)
                factors.add(i);
        }
        return factors;
    }

    public static boolean isPractical(int num, List<Integer> factors) {
        int c = 0;
        for (int i = 0; i < factors.size(); i++) {
            int allowed = i;
            List<Integer> sums = new ArrayList<>();
        }
        return c == num - 1;
    }

}