import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.util.stream.*;

public class register {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("register.dat"));
        while(scan.hasNext()) {
            double comp = scan.nextDouble();
            int[] theNums = new int[8];
            for (int i = 0; i < 8; i++) {
                theNums[i] = scan.nextInt();
            }
            double currentTotal = theNums[0]*20+theNums[1]*10+theNums[2]*5+theNums[3]*1 + theNums[4]*.25+theNums[5]*.1+theNums[6]*.05+theNums[7]*.01;
            double missing = Math.round((comp-currentTotal)*1000);
            if (missing > 0) {
                System.out.println("Missing $" + missing/(double)1000);
            } else if (missing < 0) {
                System.out.println("Over $" + Math.abs(missing)/(double)1000);
            } else {
                System.out.println("Correct");
            }
        }
        PriorityQueue pq = new PriorityQueue();
        for (int i : new int[] {7,3,4,8,9,2,2,1,4}) { pq.add(i); }
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        pq.remove();
        System.out.println(pq);
        pq.remove();
        System.out.println(pq);
        pq.remove(20);
        System.out.println(pq);
        pq.remove(7);

        Map<String, String> a= new LinkedHashMap<>();
        a.put("hi", "no");
        a.put("no", "hi");
        a.remove("no", "no");
        System.out.println(a);

        System.out.printf("%7.2f", 1234.56789);
    }

}
