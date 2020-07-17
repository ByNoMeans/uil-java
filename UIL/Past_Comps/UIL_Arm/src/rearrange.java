import java.util.*;
import java.io.*;
import java.util.stream.*;

public class rearrange {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("rearrange.dat"));
        while(scan.hasNext()) {
            String[] line = scan.nextLine().split(" ");
            String finalString = "";
            String curr = "";
            for (String word : line) {
                if (word.length()%2 == 1) {
                    String str ="";
                    ArrayList<String> chars = new ArrayList<>(Arrays.asList(word.split("")));
                    String first = String.valueOf(word.charAt(0));
                    String last = String.valueOf(word.charAt(word.length()-1));
                    chars.set(word.length()-1, (first));
                    chars.set(0, (last));
                    for (int i = 0; i < chars.size(); i++) {
                        str+= chars.get(i);
                    }
                    word = str;

                }
                if (word.length() > 3) {
                    ArrayList<String> chars = new ArrayList<>(Arrays.asList(word.split("")));
                    if (word.length() % 2 == 0) {
                        String first = String.valueOf(word.charAt(0));
                        String last = String.valueOf(word.charAt(word.length()/2-1));
                        String left = String.valueOf(word.charAt(word.length()-1));
                        String right = String.valueOf(word.charAt(word.length()/2));
                        chars.set(0, left);
                        chars.set(word.length()/2-1, (first));
                        chars.set(word.length()/2, (last));
                        chars.set(word.length()-1, (right));
                    }
                    System.out.println(chars);
                }
                finalString += curr + " ";
            }

        }

    }
}
