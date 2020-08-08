import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Physo {
    public static void main(String[] args) throws IOException {
        String fileName = "Physo".toLowerCase() + ".dat";
        String sidPath = "../past-competitions/fhwuhfui/SampleData/" + fileName;
        String compPath = String.format("./dataSet/%s", fileName);
        Scanner scan = new Scanner(new File(compPath));

        String[] input = scan.nextLine().split("\\s");
        int lines = Integer.parseInt(input[0]), x = Integer.parseInt(input[1]), y = Integer.parseInt(input[2]), w2 = Integer.parseInt(input[3]);

        // f1d1/f2 = d2
        for (int i = 0; i < lines; i++) {
            String[] ip = scan.nextLine().split("\\s");
            int x1 = Integer.parseInt(ip[0]), y1 = Integer.parseInt(ip[1]), w1 = Integer.parseInt(ip[2]);
            double d2 = (w1*DistanceFormula(x,y,x1,y1))/w2;
            System.out.printf("%.2f %.2f\n",x+d2,(double)y);
        }
    }

    public static double DistanceFormula(int x1, int y1, int x2, int y2) {
        return Math.abs(Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
    }
}