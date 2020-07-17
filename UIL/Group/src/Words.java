import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Words {
    public static void main(String[] args) throws IOException {
        String fileName = "Words".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File(fileName));

        String it = scan.nextLine();
        String[] split = it.split(" ");
        for (String x : split) {
            String[] wordSplit = x.split("");
            StringBuilder word = new StringBuilder();
            String rest = "";
            for (String l : wordSplit) {
                try {
                    Integer.parseInt(l);
                } catch (NumberFormatException nFE) {
                    if (l.equals("?") || l.equals("!") || l.equals("."))
                        rest+= l;
                    else
                        word.append(l);
                }
            }
            word.reverse();
            System.out.print(word+rest+ " ");
        }

    }
}
