import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Help {
    public static void main(String[] args) throws IOException {
        System.out.println(" _   _  _____  _      _____");
        System.out.println("| | | ||  ___|| |    | ___ \\");
        System.out.println("| |_| || |__  | |    | |_/ /");
        System.out.println("|  _  ||  __| | |    |  __/");
        System.out.println("| | | || |___ | |____| |");
        System.out.println("\\_| |_/\\____/ \\_____/\\_|");

    }
    
    public static void print2DCharArray(char[][] in) {
        IntStream.range(0, in.length).forEach(e -> System.out.println(Arrays.toString(in[e]).replaceAll("[\\s,\\[\\]]", "")));
    }
    
    public static char[][] process2DASCII(Scanner scan, int length, int width) {
        char[][] out = new char[length][width];
        for (int i = 0; i < length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < width; j++)
                out[i][j] = line.charAt(j);
        }
        return out;
    }
}
