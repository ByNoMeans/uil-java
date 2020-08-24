package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Square {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\sample\\square.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            int target = s.nextInt();
            s.nextLine();
            String result = "FREE";
            // special case is, it a perfect square?
            if(isPerfectSquare(target))
                result = "NOT " + target;
            else {
                // general case
                // start at first perfect square
                int div = 2;
                double limit = Math.sqrt(target);
                boolean found = false;
                while(!found && div <= limit) {
                    if(target % div == 0) {
                        // found factor, check it and other factor
                        int other = target / div;
                        if(isPerfectSquare(other)) {
                            result = "NOT " + other;
                            found = true;
                        }
                        else if(isPerfectSquare(div))
                            result = "NOT " + div;
                    }
                    div++;
                }
            }
            System.out.println(result);
        }
        s.close();
    }

    public static boolean isPerfectSquare(int x) {
        double squareRoot = Math.sqrt(x);
        return squareRoot == (int)squareRoot; 
    }
}