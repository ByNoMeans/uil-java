import javax.print.attribute.IntegerSyntax;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Whats {

    public static void main(String[] args) throws IOException {
        String fileName = "Whats".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\whats.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            Integer[] arr = Stream.of(scan.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            LinkedHashMap<Integer, Integer> diffs = new LinkedHashMap<>();
            for (int j = 1; j < arr.length;)
                diffs.put(arr[j] - arr[j - 1], j++);
            for (int j = 0; j < 4; j++) {
                Integer out = diffs.keySet().stream().min(Integer::compare).get();
                System.out.println(out + " " + diffs.get(out));
                diffs.remove(out);
            }
            System.out.println();
        }
    }
}







