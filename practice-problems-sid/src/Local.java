import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Local {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-1/SampleData/";
        Scanner in = new Scanner(new File(fileName + "Local".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        for (int i = 0; i < lines; i++) {
            String[] line = in.nextLine().split("\\s");
            String year = line[0];
            int warm = 0, cold = 0;
            for (int j = 1; j < line.length; j++) {
                warm += Integer.parseInt(line[j]) > 50 ? 1 : 0;
                cold += Integer.parseInt(line[j]) < 32 ? 1 : 0;
            }
            System.out.printf("%s %d %d\n",year,cold,warm);
        }
    }
}