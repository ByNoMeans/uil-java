import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Dates {
    public static void main(String[] args) throws IOException, ParseException {
        String fileName = "Dates".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File(fileName));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            String date = scan.next();
            int daysAfter = scan.nextInt();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(date));
            c.add(Calendar.DAY_OF_MONTH, daysAfter);
            String out = sdf.format(c.getTime()) ;
            System.out.println(out);
        }

    }
}
