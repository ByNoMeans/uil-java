import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Family {
    public static void main(String[] args) throws IOException {
        String fileName = "Family".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File("C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\family.dat"));
        class Person {
            int gen;
            List<String> parent;
            List<String> sibling;
            List<String> children;

            public Person(int gen, String s, String s1, String s2) {
                this.gen=gen;
                parent.add(s);
                sibling.add(s1);
                children.add(s2);
            }
        }
        while (scan.hasNext()) {
            int gens = 0;
            String s = scan.next();
            String r = scan.next();
            String d = scan.next();
            int gen = 1;
            ArrayList<Person> p = new ArrayList<>();
            if (r.equals("MOTHER") || r.equals("FATHER")) {
                p.add(new Person(gen, ));
            } else {
                h.put(gen, d);
            }
            for (int i = 0; i < a.size(); i++) {
                if (i==1)
                    System.out.println("1st Generation: ");
                else
                    System.out.println(i + "nd Generation: ");
            }
        }

    }
}
