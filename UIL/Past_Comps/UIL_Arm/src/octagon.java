import java.util.*;
import java.io.*;
import java.util.stream.*;

public class octagon {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("octagon.dat"));
        int lines = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < lines; i++) {
            double a = scan.nextDouble();
            double area = Math.round((Math.sqrt(a/(2+2*Math.sqrt(2))))*100)/(double)100;
            System.out.print(area+"\n");
        }

    }
}
