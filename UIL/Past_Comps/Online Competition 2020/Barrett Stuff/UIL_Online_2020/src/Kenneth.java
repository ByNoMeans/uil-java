import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Kenneth {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("kenneth.dat"));
        int cases = s.nextInt(); s.nextLine();
        for (int i = 0; i < cases; i++) {
            int[][] ars = new int[9][9];
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++)
                    ars[j][k] = s.nextInt();
            }
            String out = "GRID #" + (i+1) + ": " + solve(ars);
            System.out.print(out);
        }
    }

    public static String solve(int[][] sud) {
        LinkedHashSet<Integer> lhsR = new LinkedHashSet<>();
        LinkedHashSet<Integer> lhsC = new LinkedHashSet<>();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for (int i = 0; i < sud.length; i++) {
            for (int j = 0; j < sud[i].length; j++) {
                lhsR.add(sud[i][j]);
                lhsC.add(sud[j][i]);
            }
            if (lhsR.size() != 9)
                rows.add(i + 1);
            if (lhsC.size() != 9)
                cols.add(i + 1);
            lhsR.clear();
            lhsC.clear();
        }

        String rowErrors = ""; String colErrors = "";
        for(Integer i : rows)
            rowErrors += i + " ";
        for(Integer i : cols)
            colErrors += i + " ";

        if (rows.isEmpty() && cols.isEmpty())
            return "SOLUTION IS CORRECT\n" + "============\n";
        else if (rows.isEmpty())
            return "NOT A SOLUTION\n>> ROWS WITH ERRORS: NONE\n" +
                    ">> COLUMNS WITH ERRORS: " + colErrors + "\n============\n";
        else if (cols.isEmpty())
            return "NOT A SOLUTION\n>> ROWS WITH ERRORS: " + rowErrors + "\n>> COLUMNS WITH ERRORS: NONE"
                    + "\n============\n";
        else
            return "NOT A SOLUTION\n>> ROWS WITH ERRORS: " + rowErrors +
                    "\n>> COLUMNS WITH ERRORS: " + colErrors + "\n============\n";
    }
}
