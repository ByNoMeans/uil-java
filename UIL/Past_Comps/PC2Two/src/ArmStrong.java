import java.io.*;
import java.util.*;

public class ArmStrong {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("armstrong.dat"));
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int curr = sc.nextInt();
            int currtot = 0;
            int[] digits = Integer.toString(curr).chars().map(c -> c-'0').toArray();
            for (int x : digits) { currtot+=Math.pow(x, digits.length); }
            currtot = (int)Math.round(currtot);
            if (currtot == curr) {
                System.out.println("ARMSTRONG");
            } else {
                System.out.println("NOT AN ARMSTRONG");
            }
        }
    }
}
