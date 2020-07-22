import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-1/SampleData/";
        Scanner in = new Scanner(new File(fileName + "PhoneNumbers".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        for (int i = 0; i < lines; i++) {
            String line = in.nextLine(), regex = "\\d{3}-\\d{3}-\\d{4}";
            System.out.println(line.matches(regex) ? line : "INVALID PHONE NUMBER");
        }
    }
}