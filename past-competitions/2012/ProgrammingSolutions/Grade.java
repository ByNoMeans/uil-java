package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Grade {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\judges\\grade.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        
        final int UPPER = 60;
        final int LOWER = 4;
        Map<Integer, String> grades = new HashMap<Integer, String>();
        for(int i = 5; i < 20; i++)
            grades.put(i, "MORE PRACTICE");
        for(int i = 20; i < 35; i++)
            grades.put(i, "SOLID");
        for(int i = 35; i < 60; i++)
            grades.put(i, "SPORTS CENTER");
        
        String sym = "REB AST STL BLK TO FG 3FG PF FT";
        String pt = "1 1 2 1 -4 2 3 -1 1";
        String[] syms = sym.trim().split("\\s+");
        String[] pts = pt.trim().split("\\s+");
        assert syms.length == pts.length;
        
        Map<String, Integer> points = new HashMap<String, Integer>();
        for(int i = 0; i < syms.length; i++) {
            assert !points.containsKey(syms[i]);
            points.put(syms[i], Integer.parseInt(pts[i]));
        }
        
        for(int i = 1; i <= numSets; i++){
            String[] data = s.nextLine().trim().toUpperCase().split("\\s+");
            System.out.print(data[0] + " ");
            int numBad = 0;
            int score = 0;
            for(int j = 1; j < data.length; j++) {
                if(!points.containsKey(data[j]))
                    numBad++;
                else
                    score += points.get(data[j]);
            }
            if(numBad >= 5)
                System.out.println("?? INVALID");
            else {
                System.out.print(score + " ");
                if(score >= UPPER)
                    System.out.println("CAREER GAME");
                else if(score <= LOWER)
                    System.out.println("BENCHED");
                else
                    System.out.println(grades.get(score));
            }
            
        }
        s.close();
    }
}