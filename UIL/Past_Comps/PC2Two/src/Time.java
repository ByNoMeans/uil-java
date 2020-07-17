import java.io.*;
import java.util.*;

public class Time {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("time.dat"));
        while (scan.hasNextDouble()) {
            double time = scan.nextDouble();
            int hours = (int) (time / 60);
            int minutes = (int) (time) % 60;
            int seconds = (int)(Math.round((time % 60 - minutes)/0.05)*3);
            System.out.println(Math.round(-4.52));
            System.out.println(time + " = " + hours + ":" + minutes + ":" + seconds);
        }
    }
}
