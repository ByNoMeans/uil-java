import java.io.*;
import java.util.*;

public class magic {

    public static int helper(int a, int b, int c, int x) {
        return (int) (a*Math.pow(x,2)+b*x+c);
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("magic.dat"));
        Scanner s;
        //String line = scan.nextLine(); bad, must define each line inside loop
        //use hasnext and then check if 00000
        while (scan.hasNext()) {
            String line = scan.nextLine();
            if (line.equals("0 0 0 0 0"))
                break;
            int[] numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int i = 0; i <= numbers[numbers.length-1]; i++) {
                int out = helper(numbers[0], numbers[1], numbers[2], i);
                if (out % numbers[numbers.length-2] == 0) { count++; }
            }
            System.out.println(count);
        }
    }
}
