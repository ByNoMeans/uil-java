import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Qualified {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-1/SampleData/";
        Scanner in = new Scanner(new File(fileName + "Qualified".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        LinkedHashMap<String,Integer> contests = new LinkedHashMap<>();
        contests.put("STC",560);
        contests.put("WTC",340);
        contests.put("NTC",420);
        contests.put("CTC",370);
        contests.put("LVC",470);

        for (int i = 0; i < lines; i++) {
            String[] s = in.nextLine().split("\\s");
            if (contests.get(s[2]) < Integer.parseInt(s[1]))
                System.out.println(s[0]);
        }
    }
}