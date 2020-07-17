import java.io.*;
import java.util.*;
import java.lang.*;

public class Essay {
    public static void main (String[] args) throws IOException {
        Scanner scan = new Scanner(new File("palindrome.txt"));
        int number = scan.nextInt(); scan.nextLine();
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < number; i ++) {
            System.out.println("ESSAY #" + (i+1) + ":");
            String current = scan.next().replaceAll("\\p{Punct}", "");


            while (!current.equals("-") && scan.hasNext()) {
                if (current.length() > 2) {
                    String reverse = new StringBuilder(current).reverse().toString();
                    if (reverse.equals(current)) { /*System.out.println(current);*/ words.add(current); }
                }
                current = scan.next().replaceAll("\\p{Punct}", "");
            }
            Collections.sort(words);
            for (String z : words) {
                System.out.println(z);
            }
            System.out.println("--------------------");
            //Change file to .dat, don't print out dashes
        }
    }
}
