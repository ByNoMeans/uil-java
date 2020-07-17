import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Cross {
    public static void main(String[] args) throws IOException {
        String fileName = "Cross".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File(fileName));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            String[] in = scan.nextLine().split(" ");
            String[] first = in[0].split("");
            String[] second = in[2].split("");
            String letter = "";
            for (String f : second) {
                for (String s : first) {
                    if (s.equals(f)) {
                        letter = f;
                        break;
                    }
                }
            }
            if (letter.equals("")) {
                System.out.println("none\n");
                continue;
            }
            int fCount = 0;
            int sCount = 0;
            for (String f : first) {
                if (f.equals(letter))
                    break;
                fCount++;
            }
            for (String f : second) {
                if (f.equals(letter))
                    break;
                sCount++;
            }
            String indent = "";
            if (first.length > second.length) {
                for (int j = 0; j < fCount; j++)
                    indent += " ";
                boolean done = false;
                for (String s : second) {
                    if (s.equals(letter) && !done) {
                        System.out.println(in[0]);
                        done = true;
                    } else
                        System.out.println(indent + s);
                }
            } else {
                for (int j = 0; j < sCount; j++)
                    indent += " ";
                boolean d = false;
                for (String s : first) {
                    if (s.equals(letter) && !d) {
                        d = true;
                        System.out.println(in[2]);
                    } else {
                        System.out.println(indent + s);
                    }
                }
            }
            System.out.println();
        }
    }
}
