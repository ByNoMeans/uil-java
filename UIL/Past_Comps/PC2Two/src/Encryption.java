import java.io.*;
import java.util.*;
public class Encryption {
public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(new File("encryption.dat"));
    int numLines = scan.nextInt();
    for (int i = 0; i < numLines; i++) {
        String each = scan.next();
        int[] intArray = Arrays.stream(each.split("")).mapToInt(Integer::parseInt).toArray();
        for (int z = 0; z < intArray.length; z++) {
            intArray[z] = (intArray[z]+7) % 10;
        }
        for (int j = 0; j < intArray.length; j++) {
            if ( j == 0 || j == 4 || j == 8 || j == 12) {
                int temp = intArray[j];
                intArray[j] = intArray[j+2];
                intArray[j+2] = temp;
            }
            if ( j == 3 || j == 7 || j == 11 || j == 15 ) {
                int temp = intArray[j-2];
                intArray[j-2] = intArray[j];
                intArray[j] = temp;
            }
        }
        String toPrint = "";
        for (int e : intArray) { toPrint+=e; }
        System.out.println(toPrint);
    }
}

}
