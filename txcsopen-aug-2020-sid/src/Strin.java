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


        Scanner scan = new Scanner(new File(compPath));

        int lines = scan.nextInt();
        scan.nextLine();

        List<String> s = new ArrayList<>();

        for (int i = 0; i < lines; i++) {
            s.add(scan.nextLine());
        }

        s.clear();

        s.add("aaabb");
        s.add("bbbccc");

        String together = "";
        int j = 0;
        for (int i = 0; i < s.size() - 1; i++) {
            String c = s.get(i), n = s.get(i+1), sub = "";
            for (j = c.length()-1; j >= 0; j--) {
                if (c.charAt(j) != n.charAt(c.length() - j - 1))
                    break;
                sub += c.charAt(j);
            }
            together += c.substring(0, j+1) + sub + n.substring(c.length() - j - 1);
            System.out.println(together);
        }
        System.out.println(together.length());
    }
}