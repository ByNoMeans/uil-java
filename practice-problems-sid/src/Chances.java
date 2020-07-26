import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Chances {
    public static void main(String[] args) throws IOException {
        String fileName = "Chances".toLowerCase()+".dat";
        String sidPath = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2020-indeed/solutions/" + fileName;
        Scanner scan = new Scanner(new File(sidPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            double p = scan.nextDouble();
            int n = scan.nextInt();
            scan.nextLine();
            System.out.println((int)((p*n)/100));
        }
    }
}