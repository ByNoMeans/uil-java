import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class MultChoice {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-2/SampleData/";
        Scanner in = new Scanner(new File(fileName + "MultChoice".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        for (int i = 0; i < lines;) {
            List<List<String>> opt = new ArrayList<>();
            for (int j = 0; j < 5; j++)
                opt.add(Arrays.asList(in.nextLine().replaceAll(",|(and)", "").split("\\s")));
            List<String> largest = new ArrayList<>();
            int maxLen = 0;
            for (List<String> s : opt) {
                maxLen = Math.max(maxLen, s.size());
            }
            for (List<String> s : opt) {
                if (s.size() == maxLen) largest.addAll(s);
            }
            for (List<String> strings : opt) {
                for (String x : strings) {
                    if (largest.contains(x)) {
                        strings.add("only");
                    }
                }
            }
            System.out.println("Question "+ ++i);
            for (List<String> list : opt) {
                StringBuilder out = new StringBuilder();
                for (String s : list) {
                    out.append(s);
                }
                System.out.println(out);
            }
        }
    }
}