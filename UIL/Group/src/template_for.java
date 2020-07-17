import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.lang.*;

public class template_for {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("sort.dat"));
//        int lines = scan.nextInt();
//        scan.nextLine();
//
//        for (int i = 0; i < lines; i++) {
//
//        }

    }

    static class Methods {

        public void Date() {
//            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//            Calendar c = Calendar.getInstance();
//            c.setTime(sdf.parse(date));
//            c.add(Calendar.DAY_OF_MONTH, daysAfter);
//            String newDate = sdf.format(c.getTime());
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
        public static long LCM(ArrayList<Integer> arr) {
            long lcm = 1;
            int divisor = 2;
            while (true) {
                int counter = 0;
                boolean divisible = false;
                for (int i = 0; i < arr.size(); i++) {
                    if (arr.get(i) == 0)
                        return 0;
                    else if (arr.get(i) < 0)
                        arr.set(i, arr.get(i) * -1);
                    if (arr.get(i) == 1)
                        counter++;
                    if (arr.get(i) % divisor == 0) {
                        divisible = true;
                        arr.set(i, arr.get(i) / divisor);
                    }
                }
                if (divisible)
                    lcm *= divisor;
                else
                    divisor++;
                if (counter == arr.size())
                    return lcm;
            }
        }
    }
}


