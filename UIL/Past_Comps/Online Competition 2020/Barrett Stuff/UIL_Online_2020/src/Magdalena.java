import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Magdalena {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("magdalena.dat"));
        int lines = scan.nextInt();
        scan.nextLine();
        for (int i = 1; i <= lines; i++) {
            int b = scan.nextInt();
            String num = scan.next();
            scan.nextLine();
            String out = "";

            if (num.length() == 1) {
                System.out.println("Case #" + i + ": " + num);
            } else if (num.length() > 1) {
                for (int z = num.length() - 1; z > 0; z--)
                    out = "" + SYMBOLS.charAt(b - 1) + out;
                char largestDigit = num.charAt(0);
                char oneLessThanFirst = SYMBOLS.charAt(SYMBOLS.indexOf(num.charAt(0)) - 1);
                if ((largestDigit + out).equals(num)) {
                    out = largestDigit + out;
                } else if (oneLessThanFirst != '0') {
                    out = oneLessThanFirst + out;
                }
                System.out.println("Case #" + i + ": " + toInputBase(sumDigitsInBase10(out), b));
            }
        }
    }

    private static final String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String toInputBase(int inputNum, int base) {
        String s = "";
        while (inputNum > 0) {
            s += SYMBOLS.charAt(inputNum % base);
            inputNum /= base;
        }
        StringBuilder ix = new StringBuilder();
        ix.append(s);
        return new String(ix.reverse());
    }

    public static int sumDigitsInBase10(String anyBaseInput) {
        int rest = 0;
        for(String x : anyBaseInput.split(""))
            rest += SYMBOLS.indexOf(x);
        return rest;
    }

}

