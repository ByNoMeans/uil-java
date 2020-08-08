import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Functo {
    public static void main(String[] args) throws IOException {
        String fileName = "Functo".toLowerCase() + ".dat";
        String sidPath = "../past-competitions/urmum/SampleData/" + fileName;
        String compPath = String.format("./dataSet/%s", fileName);
        Scanner scan = new Scanner(new File(compPath));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            double y = Double.parseDouble(scan.nextLine());
            System.out.println(solveEquation(y).toString().replaceAll("[\\[\\],]",""));
        }
        //System.out.println(function(55.546));

    }
    public static List<Double> solveEquation(double y) {
        y = round(y, 2);
        List<Double> sols = new ArrayList<>();
        for (double i = 1.000; i <= 100.000; i += 0.001) {
            //i = round(i, 3);
            double z = round(function(i), 2);
            //System.out.println(z);
            if (z == y && !sols.contains(i))
                sols.add(i);
        }
        Collections.sort(sols);
        return sols;
    }

    public static double function(double i) {
        return i + Math.pow(i, 1.5) - Math.pow(i, 1.4) + Math.log10(i) + Math.sqrt(i) + 1 / (i + 1.0) + Math.sin(i) - Math.pow(1.1, i) + Math.pow(1.2, i - 50.0) + Math.cos(i);
    }

    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}