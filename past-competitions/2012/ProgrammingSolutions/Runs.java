package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Runs {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\judges\\runs.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            
            double H, W, HBP, HR, IW, TB, SB, CS, GDP, AB, A, B, C, D;
            int  AR, PR;
            H =  s.nextInt();
            W =  s.nextInt();
            HBP =  s.nextInt();
            HR =  s.nextInt();
            IW =  s.nextInt();
            TB =  s.nextInt();
            SB =  s.nextInt();
            CS =  s.nextInt();
            GDP = s.nextInt();;
            AB = s.nextInt();
            AR = s.nextInt();
            A = H + W + HBP - HR - .5 * IW;
            B = (1.4*TB - .6*H - 3*HR + .1*(W + HBP - IW) + .9*(SB - CS - GDP))*1.1;
            C = AB - H + CS + GDP;
            D = HR;

            PR = (int) Math.round(A * B / (B + C) + D);
            System.out.print(PR + " ");
            if(AR < PR)
                System.out.println("UNLUCKY");
            else if(AR > PR)
                System.out.println("LUCKY");
            else
                System.out.println("VALID");
            
        }
        s.close();
    }
}
