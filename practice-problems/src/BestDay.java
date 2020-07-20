import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class BestDay {
    public static void main(String[] args) throws IOException {
        //String fileName = "BestDay".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-2\\SampleData\\bestday.dat"));

        int lines = scan.nextInt();
        scan.nextLine();
        String[] weekDays = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};

        for (int i = 0; i < lines; i++) {
            System.out.println(weekDays[largestOfStringNums(scan.nextLine())]);
        }

    }
}



