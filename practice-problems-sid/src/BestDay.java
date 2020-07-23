import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class BestDay {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-2/SampleData/";
        Scanner in = new Scanner(new File(fileName + "BestDay".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        List<String> d = Arrays.asList("SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY");

        for (int i = 0; i < lines; i++) {
            List<Integer> val = Arrays.stream(in.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(d.get(val.indexOf(val.stream().max(Integer::compareTo).orElseThrow())));
        }
    }
}