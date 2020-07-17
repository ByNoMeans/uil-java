import java.util.*;
import java.io.*;
import java.util.stream.*;

public class most_value {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("most_value.dat"));
        while(scan.hasNext()) {
            String line = scan.nextLine();
            String[] ints = line.split(" ");
            int[] realInts = new int[ints.length];
            for (int i = 0; i < realInts.length; i++) {
                realInts[i] = Integer.valueOf(ints[i]);
            }

            ArrayList<Integer> arrValues = new ArrayList<>();
            for (int x : realInts) {
                if (!arrValues.contains(x)) {
                    arrValues.add(x);
                }
            }
            int[] occur = new int[arrValues.size()];

            int sum = 0;
            for (int x : realInts) {
                int index = arrValues.indexOf(x);
                occur[index]++;
                sum+=x;
            }
            int largest = 0;
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i <occur.length; i++) {
                a.add(occur[i]);
            }
            int max = Collections.max(a);
            System.out.println(arrValues.get(a.indexOf(max)) + " accounts for " + (max * arrValues.get(a.indexOf(max))) + " of the sets total value of " + sum);

        }
    }
}
