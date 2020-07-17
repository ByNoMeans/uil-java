import java.util.*;
import java.io.*;
import java.util.stream.*;

public class card_sort {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("card_sort.dat"));

        ArrayList<Integer> powers = new ArrayList<>();
        int biggestPower = 0;
        int biggestAttack = 0;
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] lineSplit = line.split("/");
            int currPow = Integer.valueOf(lineSplit[1]) + Integer.valueOf(lineSplit[2]);
            if (currPow == biggestPower) {
                if (Integer.valueOf(lineSplit[1]) > biggestAttack) {
                    biggestPower = 0;
                }

            }
        }
    }
}
