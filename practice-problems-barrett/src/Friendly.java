import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Friendly {
    public static void main(String[] args) throws IOException {
        String fileName = "Friendly".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\friendly.dat"));

        while (scan.hasNext()) {
            String[] arr = scan.nextLine().split(" ", 2);
            String time = arr[0];
            byte A = (byte) (9 * Integer.parseInt(time.split(":")[0]));
            byte B = (byte) (3 *(Integer.parseInt(time.split(":")[1])) + Integer.parseInt(time.split(":")[2]));
            String msg = arr[1];
            String out = "";
            for (int i = 0; i < msg.length(); i++) {
                if (i % 2 == 0) {
                    out += (A ^ msg.charAt(i)) + " ";
                } else {
                    out += (B ^ msg.charAt(i)) + " ";
                }
            }
            String fin = time + " ";
            for (String c : out.split(" "))
                fin += "0x"+(""+Integer.toHexString(Integer.parseInt(c))).toUpperCase() + " ";
            System.out.println(fin);
        }

    }
}
