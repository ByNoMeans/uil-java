import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Friendly {
    public static void main(String[] args) throws IOException {
        String fileName = "Friendly".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\friendly.dat"));

        while (scan.hasNext()) {
            String[] arr = scan.nextLine().split(" ");
            String word="";
            for (int i = 1; i < arr.length; i++) {
                word += arr[i] + " ";
            }
            word=word.trim();
            String time = arr[0];
            int A = 9 *Integer.parseInt(time.split(":")[0]);
            int B = 3 * Integer.parseInt(time.split(":")[2]) + Integer.parseInt(time.split(":")[1]);
            System.out.print(time + " ");
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0){
                    System.out.print("0x"+Integer.toHexString(Math.abs((byte)(word.charAt(i) ^ A))) + " ");
                } else {
                    System.out.print("0x"+Integer.toHexString(Math.abs((byte)(word.charAt(i) ^ B))) + " ");
                }
            }
            System.out.println();
        }

    }
}
