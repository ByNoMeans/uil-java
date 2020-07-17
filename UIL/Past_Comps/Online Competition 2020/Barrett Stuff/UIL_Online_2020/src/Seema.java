import java.util.*;
import java.io.*;

public class Seema
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("seema.dat"));
        String ln = scan.nextLine();
        List<String> items = Arrays.asList(ln.split("\\s*,\\s*"));
        Collections.sort(items);
        System.out.println(items);
        ArrayList<String> newItems = new ArrayList<String>();
        ArrayList<Integer> occurrences = new ArrayList<Integer>();
        for(int i = 0; i < items.size(); i++)
        {
            if(!newItems.contains(items.get(i)))
            {
                newItems.add(items.get(i));
                occurrences.add(1);
            }
            else
            {
                int index = newItems.indexOf(items.get(i));
                occurrences.set(index, occurrences.get(index) + 1);
            }
        }
        int maxOccurrences = 0;
        for(int i = 0; i < newItems.size(); i++)
        {
            if(occurrences.get(i) > maxOccurrences)
                maxOccurrences = occurrences.get(i);
        }
        while(maxOccurrences > 0)
        {
            for(int i = 0; i < newItems.size(); i++)
            {
                if(occurrences.get(i) == maxOccurrences)
                    System.out.println(newItems.get(i) + " " + occurrences.get(i));
            }
            maxOccurrences--;
        }
    }
}
