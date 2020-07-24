import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class MultChoice {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Desktop\\Github\\uil-java\\past-competitions\\2013-2\\SampleData\\multchoice.dat"));
        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines;) {
            ArrayList<List<String>> opt = new ArrayList<>();
            ArrayList<String> original = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String line = scan.nextLine();
                original.add(line);
                opt.add(Arrays.asList(line.replaceAll(",|(and )", "").split("\\s")));
            }
            ArrayList<String> largest = new ArrayList<>();
            int big = opt.stream().mapToInt(List::size).max().orElseThrow();
            int finalMaxLen = big;
            for (List<String> s : opt) {
                if (s.size() == big) largest.addAll(s);
            }

            for (int j = 0; j < opt.size(); j++) {
                for (String string : opt.get(j)) {
                    if (largest.contains(string) && opt.get(j).size() != big)
                        opt.get(j).set(0, "only");
                }
            }

            System.out.println("Question "+ ++i);
            for (int j = 0; j < original.size(); j++)
                System.out.println(original.get(j) + ((opt.get(j).get(0).equals("only")) ? " only" : ""));
        }
    }
}



