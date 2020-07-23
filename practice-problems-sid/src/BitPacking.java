import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class BitPacking {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-2/SampleData/";
        Scanner in = new Scanner(new File(fileName + "BitPacking".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        for (int i = 0; i < lines; i++) {
            String l = Integer.toBinaryString(Integer.parseInt(in.nextLine()));
            int t = Integer.parseInt(l.substring(8,13),2)+65;
            int st = Integer.parseInt(l.substring(13,19),2);
            int iv = Integer.parseInt(l.substring(19),2);
            char type = (char) t;
            char subtype = (char) (st >= 1 && st <= 26 ? (char)65+st :
                    st >= 27 && st <= 52 ? (char)97+st :
                            (char)48+st);
            System.out.printf("Binary: %s%n",l);
            System.out.printf("Type: %c | Sub Type: %c | Inventory: %d\n",type,subtype,iv);
        }
    }
}