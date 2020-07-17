import java.io.*;
import java.util.*;

public class Independence {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("independence.dat"));
        String[] theDec = scan.nextLine().split("\\s+");
        String toRet = ""; int longest = 0;
        for (int i = 0; i < theDec.length; i++) {
            longest = Math.max(longest, theDec[i].length());
        }
        for (String x : theDec) {
            if (x.length() == longest)
                toRet += x.charAt(0);
        }
        System.out.println(toRet);
    }
}
