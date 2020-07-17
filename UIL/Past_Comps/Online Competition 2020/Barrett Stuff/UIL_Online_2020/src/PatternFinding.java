import java.util.*;
import java.io.*;

public class PatternFinding
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("PatternFinding.dat"));
        int n = scan.nextInt();
        int k = scan.nextInt();
        String s = "";
        for(int i = 0; i <= n; i++) {
            s += scan.nextInt();
        }

        ArrayList<String> subs = new ArrayList<>();
        int count = 0;
        for(int i = s.length(); i >= 0; i--) {
            subs.clear();
            count = 0;
            for(int j = 0; j <= n-i+1; j++)
                subs.add(s.substring(j, i+j));
            String mode = mode(subs);

            for(String substring : subs)
                if(substring.equals(mode))
                    count++;
            if(count>=k)
            {
                System.out.println(i);
                break;
            }
        }

    }

    public static String mode(ArrayList<String> array) {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        int max  = 1;
        String temp = "";

        for(int i = 0; i < array.size(); i++) {

            if (hm.get(array.get(i)) != null) {

                int count = hm.get(array.get(i));
                count++;
                hm.put(array.get(i), count);

                if(count > max) {
                    max  = count;
                    temp = array.get(i);
                }
            }

            else
                hm.put(array.get(i),1);
        }
        return temp;
    }
}
