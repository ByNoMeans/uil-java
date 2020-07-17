import java.io.*;
import java.lang.*;
import java.util.*;

public class Climb {
    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(new File("climb.txt"));
        int times = scan.nextInt(); scan.nextLine();
        String x = "hi one two three four";
        String[] xarr = x.split(" ", 1);
        System.out.println(Arrays.toString(xarr));
        for (int i = 1; i < 20; i++) {
            System.out.println((""+i).equals(String.valueOf(i)));
        }
//        for (int i = 0; i < times; i++) {
//            int up = scan.nextInt(); int fall = scan.nextInt(); int ballsDeep = scan.nextInt();
//            int height = 0; int count = 0; int distance = 0;
//            while (height <= ballsDeep) {
//                height += up;
//                if (height >= ballsDeep){ count++; distance += up; break; }
//                height -= fall;
//                distance += up + fall;
//                count++;
//            }
//            System.out.println(count + " " + distance);
//        }
    }
    //CHANGE INPUT TO DAT
    //CHANGE INPUT TO DAT
    //CHANGE INPUT TO DAT
}
