package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Match {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\judges\\match.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        
        String valid = "ABCDEX";

        for(int i = 1; i <= numSets; i++){
            String a1 = s.nextLine();
            String a2 = s.nextLine();
            assert a1.length() == 10 && a2.length() == 10;
            double score = 0;
            for(int j = 0; j < a1.length(); j++) {
                char c1 = a1.charAt(j);
                char c2 = a2.charAt(j);
                assert valid.indexOf(c1) >= 0 && valid.indexOf(c2) >= 0;
                if(c1 == 'X' && c2 == 'X') {
                    c1 = 'A';
                    c2 = 'E';
                }
                else if(c1 == 'X' && c2 < 'C')
                    c1 = 'E';
                else if(c1 == 'X')
                    c1 = 'A';
                else if(c2 == 'X' && c1 < 'C')
                    c2 = 'E';
                else if(c2 == 'X')
                    c2 = 'A';
                int diff = c1 - c2;
                score += diff * diff;
            }
            int overall = (int) Math.round(Math.sqrt(score));
            assert overall >= 0 && overall <= 13;
            System.out.println(i + " " + overall);
        }
        s.close();
    }
}
