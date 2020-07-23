import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Waitlist {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-2/SampleData/";
        Scanner in = new Scanner(new File(fileName + "Waitlist".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < lines; i++) list.add(in.nextLine().split("\\s"));
        list.forEach(s -> {
            System.out.printf("%s %d%n",s[0],Integer.parseInt(s[1])-Integer.parseInt(s[2]) < 0 ? Math.abs(Integer.parseInt(s[1])-Integer.parseInt(s[2])) : 0);
        });
    }
}