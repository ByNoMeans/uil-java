import java.util.*;
import java.io.*;

public class cost {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("cost.dat"));
        Scanner s;
        int lines = scan.nextInt(); scan.nextLine();
//        for (int i = 0; i < lines; i++) {
//            String each = scan.nextLine();
//            ArrayList<Integer> arr = new ArrayList<>();
//            s = new Scanner(each);
//            while (s.hasNextInt()) {
//                arr.add(s.nextInt());
//            }
//            Collections.sort(arr);
//            System.out.println("Case " + (i+1) + ": " + arr.get(1));
//        }
        System.out.println("First int: 7");
        String re = Integer.toString(Integer.parseInt(7+"", 8), 5);
        System.out.println("7 from base  8to base 5: " + re);
        System.out.printf("%f%n", 5);
    }
}
