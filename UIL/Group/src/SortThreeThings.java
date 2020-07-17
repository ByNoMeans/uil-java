import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SortThreeThings {

    public static void main(String[] args) throws Throwable {
        Scanner kb = new Scanner(new File("sort.dat"));
        ArrayList<Person> list = new ArrayList<>();
        while(kb.hasNext())
        {
            String[] s = kb.nextLine().split("\\s+");
            list.add(new Person(s[0],s[1],Double.parseDouble(s[2])));
        }
        sort(list,0,list.size()/2,list.size());
        for(Person p : list)
            System.out.println(p);
    }

    private static void sort(ArrayList<Person> list, int i, int j, int size) {
        if(j == i)
            return;
        for(int x = i; x < j; x++) {
            int p = x;
            for(int y = x+1; y < j; y++)
            {
                if(compare(list.get(p),list.get(y)) > 0)
                {
                    p = y;
                }
            }
            list.set(x, list.set(p, list.get(x)));
        }
        sort(list,j,(j+size)/2,size);
    }

    private static int compare(Person p1, Person p2) {
        if(!p1.last.equals(p2.last))
            return p1.last.compareTo(p2.last);
        if(!p2.first.equals(p1.first))
            return p1.first.compareTo(p2.first);
        return Double.compare(p1.height, p2.height);
    }
}
class Person {
    String last;
    String first;
    double height;
    public Person(String l, String f, double h)
    {
        last = l;
        first = f;
        height = h;
    }
    public String toString()
    {
        return first+" "+last+" "+height;
    }

}
