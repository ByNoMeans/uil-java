import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Guowei {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("guowei.dat"));
        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            int dist = scan.nextInt(); scan.nextLine();
            String str = scan.nextLine();
            if (dist > str.length()) {
                int ind = dist % str.length();
                if (ind + 40 < str.length()) {
                    System.out.println(str.substring(ind, ind + 40));
                } else {
                    System.out.println(str.substring(ind - (ind / str.length() + 1)) + " " + str.substring(0, (ind+38) % str.length()));
                }
            } else {
                System.out.println(str.substring(dist, (dist + 40)));
            }
        }

    }
}
