package _UTCS_2012;
import java.io.*;
import java.util.*;

public class Base {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\judges\\base.dat"));
        int numSets = s.nextInt();
        s.nextLine();
        
        String digits = "0123456789abcdefghijklmnopqrstuvwxyz!?@#$%";
        assert digits.length() == 42;

        for(int i = 1; i <= numSets; i++){
            String base42Num = s.nextLine();
            int mult = 1;
            if(base42Num.charAt(0) == '-') {
                mult = -1;
                base42Num = base42Num.substring(1);    
            }
            else if(base42Num.charAt(0) == '+') 
                base42Num = base42Num.substring(1);  
            assert base42Num.length() > 0 : "no digits left";
            int result = 0;
            int place = 1;
            int remain = Integer.MAX_VALUE;
            for(int j = base42Num.length() - 1; j >= 0; j--) {
                char ch = base42Num.charAt(j);
                int digit = digits.indexOf(ch);
                assert digit >= 0 : "bad digit";
                int temp = place * digit;
                assert temp < remain : "overflow!";
                // System.out.println(temp + " " + remain);
                result += temp;
                remain -= temp;
                place *= 42;
            }
            System.out.println(result * mult);
        }
        s.close();
    }
}
