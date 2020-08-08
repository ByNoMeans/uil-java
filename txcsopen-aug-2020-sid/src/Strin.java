import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Strin {
    public static void main(String[] args) throws IOException {
        String fileName = "Strin".toLowerCase() + ".dat";
        String sidPath = "../past-competitions/jfjfjlfdenb/SampleData/" + fileName;
        String compPath = String.format("./dataSet/%s", fileName);


        Scanner scan = new Scanner(new File(fileName));

        int lines = scan.nextInt();
        scan.nextLine();

        List<String> s = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            s.add(scan.nextLine());
        }

        StringBuilder together = new StringBuilder();

        for (int i = 0; i < s.size() - 1; i++) {
            String c = s.get(i), n = s.get(i+1), substr = "";
            for (int j = c.length()-1; j >= 0; j--) {
                if (c.charAt(j) == n.charAt(c.length() - j - 1))
                    substr += "" + c.charAt(j);
                else break;
            }
            together.append(c.replaceAll(substr, "")).append(substr).append(n.replaceAll(substr, ""));
        }
        System.out.print(together.length());
    }
}