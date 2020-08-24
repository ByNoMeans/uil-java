package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Climb {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\judges\\climb.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            double length = s.nextDouble() * 1000;
            double gradient = s.nextDouble() / 100;
            String end = s.next().trim();
            assert end.equals("YES") || end.equals("NO");
            int endBonus = (end.equals("YES")) ? 250 : 0;
            int climbs = s.nextInt();
            assert climbs > 0;
            int climbsBonus = (climbs == 4 || climbs == 5) ? 50 : (climbs >= 6) ? 100 : 0;
            int ds = (int) Math.round(length * gradient + endBonus + climbsBonus);
            assert ds > 0;
            String cat = "HC";
            if(ds <= 150)
                cat = "CAT 4";
            else if(ds <= 320)
                cat = "CAT 3";
            else if(ds <= 550)
                cat = "CAT 2";
            else if(ds <= 1000)
                cat = "CAT 1";
            System.out.println(i + " " + ds + " " + cat);
        }
        s.close();
    }
}

