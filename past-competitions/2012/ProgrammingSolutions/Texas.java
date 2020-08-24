package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Texas {
    public static void main(String[] args) throws IOException{


        String[] song = {"Texas Fight, Texas Fight,","And it's goodbye to A&M.",
        "Texas Fight, Texas Fight,", "And we'll put over one more win.", "Texas Fight, Texas Fight,",
        "For it's Texas that we love best.","Hail, Hail, The gang's all here,",
        "And it's good-bye to all the rest!"};
        
        assert song.length == 8;
        int ts = 0;
        for(int i = 0; i < song.length; i++) {
            String newline = song[i].toLowerCase();
            ts += countTs(newline);
            System.out.println((i + 1) + " " + ts);
            for(int j = 0; j <= i; j++)
                System.out.println(song[j]);
        }
        
        
    }

    private static int countTs(String newline) {
        int result = 0;
        for(int i = 0; i < newline.length(); i++)
            if(newline.charAt(i) == 't')
                result++;
        return result;
    }
}








