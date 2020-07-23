import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Waitlist {
    public static void main(String[] args) throws IOException {
        String fileName = "Waitlist".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Desktop\\Github\\uil-java\\past-competitions\\2013-2\\SampleData\\waitlist.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            String s = scan.next();
            int o = scan.nextInt();
            int a = scan.nextInt();
            System.out.println(s + " " + Math.max(a - o, 0));
            scan.nextLine();
        }

    }
}



