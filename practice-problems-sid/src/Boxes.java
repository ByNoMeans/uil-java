import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Boxes {
    public static void main(String[] args) throws IOException {
        String fileName = "Boxes".toLowerCase() + ".dat";
        String sidPath = "../past-competitions/2010/SampleData/" + fileName;
        Scanner scan = new Scanner(new File(sidPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            int m = scan.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(scan.nextInt() * scan.nextInt() * scan.nextInt());
                scan.nextLine();
            }
            System.out.println("Box Set " + (i+1));
            int sum = list.stream().reduce(0, Integer::sum);
            System.out.println(sum);
            System.out.println(list.stream().max(Integer::compareTo).orElseThrow() + ", " + list.stream().min(Integer::compareTo).orElseThrow());
        }
    }
}