import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Kinga {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("kinga.dat"));
        while (scan.hasNext()) {
            int current = scan.nextInt();
            System.out.print("  ");
            int currChar = 'A';
            for (int i = 0; i < current; i++) {
                if (i == (current-1))
                    System.out.print((char)currChar);
                else
                    System.out.print((char)currChar+"|");
                currChar++;
            }
            System.out.println();

            int num = 0;
            String zeroes = "00000000000000";

            for (int i = 0; i < (int)Math.pow(2, current); i++) {
                System.out.print((i+1) + " ");
                String[] fin = (zeroes.substring(0, current - Integer.toBinaryString(num).length()) + Integer.toBinaryString(num)).split("");
                for (int j = 0; j < current; j++) {
                    if (j == fin.length-1) {
                        System.out.print(fin[j]);
                    } else {
                        System.out.print(fin[j]+"|");
                    }
                }
                num++;
                System.out.println();
            }

            System.out.println("======");

        }

    }
}
