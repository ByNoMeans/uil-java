import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class HammingDistance {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("ramiro.dat"));
        int lines = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < lines; i++) {
            long firstHex = Long.parseLong(scan.next(), 16);
            long secondHex = Long.parseLong(scan.next(), 16);
            System.out.println(hammingDistance(firstHex, secondHex));
        }
    }

    public static int hammingDistance(long n1, long n2) {
        long l = Long.parseLong("" + BigInteger.valueOf(n1).xor(BigInteger.valueOf(n2)));
        int setBits = 0;

        while (l > 0) {
            setBits += l & 1;
            l >>= 1;
        }

        return setBits;
    }
}
