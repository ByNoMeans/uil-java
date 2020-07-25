import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Sort {
    public static void main(String[] args) throws IOException {
        String fileName = "Sort".toLowerCase() + ".dat";
        String barrettPath = "C:\\Users\\barre\\Desktop\\Github\\uil-java\\past-competitions\\2020-indeed\\solutions\\sort.dat";
        String sidPath = "../past-competitions/2013-1/SampleData/" + fileName;
        Scanner scan = new Scanner(new File(barrettPath));

        List<Person> peeps = new ArrayList<>();

        while (scan.hasNext()) {
            String lastName = scan.next();
            String firstName = scan.next();
            double height = scan.nextDouble();
            scan.nextLine();
            peeps.add(new Person(firstName, lastName, height));

        }
        int start = 0;
        int end = peeps.size() / 2;
        for (int i = 0; i < (int)Math.sqrt(peeps.size()) + 1; i++) {
            List<Person> peeps2 = new ArrayList<>();
            for (int j = start; j < end; j++) {
                peeps2.add(peeps.get(j));
            }
            Collections.sort(peeps2);
            for (Person p : peeps2){
                System.out.println(p.firstName + " " + p.lastName + " " + p.height);
            }

            start = end;
            end += Math.ceil((peeps.size() - start)/2.0);
            if (end >0 && end < 5) end++;

        }

    }
    
    public static void print2DCharArray(char[][] in) {
        IntStream.range(0, in.length).forEach(e -> System.out.println(Arrays.toString(in[e]).replaceAll("[\\s,\\[\\]]", "")));
    }

    public static class Person implements Comparable<Person> {
        String firstName;
        String lastName;
        double height;

        public Person (String firstName, String lastName, double height) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.height = height;
        }
        public int compareTo(Person person) {
            int c1 = firstName.compareTo(person.firstName);
            int c2 = lastName.compareTo(person.lastName);
            int c3 = Double.compare(height, person.height);
            return c2 != 0 ? c2 : (c1 != 0 ? c1 : (c3));
        }
    }

    public static char[][] process2DASCII(Scanner scan, int length, int width) {
        char[][] out = new char[length][width];
        for (int i = 0; i < length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < width; j++)
                out[i][j] = line.charAt(j);
        }
        return out;
    }
}
