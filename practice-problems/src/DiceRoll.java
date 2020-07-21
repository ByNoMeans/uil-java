import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DiceRoll {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\diceroll.dat"));
        int cases = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < cases; i++) {
            Random rand = new Random(scan.nextLong());
            int r = rand.ints(1, 1, 5).findFirst().getAsInt() % 2;
            rand.ints(1, 123);
            int r2 = rand.ints(1, 1, 26).findFirst().getAsInt() % 4;
            if (r <= 2) {
                String out = r2 == 0 ? "WHITE" : "RED";
                System.out.println(out);
            } else {
                String out = r2 == 0 ? "WHITE" : "BLUE";
                System.out.println(out);
            }
        }
    }
}
