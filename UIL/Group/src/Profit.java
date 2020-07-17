import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Profit {
    public static void main(String[] args) throws IOException {
        String fileName = "profit".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File(fileName));

        int lines = scan.nextInt();
        int rate = scan.nextInt();

        double sumPrice = 0.0;
        double sumTax = 0.0;
        double sumProfit = 0.0;
        System.out.print("      Price     *       Tax      *     Profit     *\n***************************************************\n");
        String indent = "               ";
        for (int i = 0; i < lines; i++) {
            double curr = scan.nextDouble();
            sumPrice += curr;
            double tax = curr / rate;
            sumTax+= tax;
            double profit = curr-tax;
            System.out.print(indent.substring(0, indent.length() - String.valueOf(curr).length() - 2));
            System.out.printf("$%.2f *", curr);
            System.out.print(indent.substring(0, indent.length() - String.valueOf(tax).length() - 2));
            System.out.printf("$%.2f *", tax);
            System.out.print(indent.substring(0, indent.length() - String.valueOf(profit).length() - 2));
            System.out.printf("$%.2f *", profit);
            System.out.println();
            sumProfit += profit;
        }
        System.out.println("***************************************************");
        System.out.print(indent.substring(0, indent.length() - String.valueOf(sumPrice).length() - 2));
        System.out.printf("$%.2f *", sumPrice);
        System.out.print(indent.substring(0, indent.length() - String.valueOf(sumTax).length() - 2));
        System.out.printf("$%.2f *", sumTax);
        System.out.print(indent.substring(0, indent.length() - String.valueOf(sumProfit).length() - 2));
        System.out.printf("$%.2f *", sumProfit);

    }
}
