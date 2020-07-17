import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class album_length {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("album_length.dat"));
        int lines = scan.nextInt();
        scan.nextLine();
        int totalTime = 0;
        for (int i = 0; i < lines; i++) {
            String[] almost = (scan.nextLine().split(",")[1].trim().split(":"));
            int time = Integer.parseInt(almost[0])*60+Integer.parseInt(almost[1]);
            totalTime += time;
        }
        int minutes = totalTime / 60;
        int seconds = totalTime % 60;
        System.out.print("The album length is " + minutes +":"+ seconds);
        System.out.println(Math.round(-4.5));
        System.out.printf("Hello %s!%n", "World");
        System.out.printf("%d%n", Byte.MAX_VALUE);
        System.out.println();
        System.out.printf("simple integer: %d%n", 10000L);
        System.out.printf("'%1.0f'%n", -5.5);

    }
}
