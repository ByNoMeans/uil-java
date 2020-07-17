import java.io.*;
import java.util.*;

public class Compare {
    public static void main(String[] args) throws IOException {
        String str = "9th Annual Indeed Computer Science UIL Invitational";
        Scanner scan = new Scanner(new File("compare.dat"));
        for (int i = 0; i < 8; i ++) {
            int count = 0;
            String comp = scan.nextLine();
            //one may be longer than the other, loop less than shorter
            //aka getting rid of out of bounds
            String looper = comp.length() > str.length() ? str : comp;
            for (int c = 0; c < looper.length(); c++) {
                Character one = comp.charAt(c);
                Character two = str.charAt(c);
                if (one.equals(two))
                    count++;
            }
            System.out.println(count);
        }
    }
}
