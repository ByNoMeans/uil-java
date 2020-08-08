import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Mirrin {
    public static void main(String[] args) throws IOException {
        String fileName = "Mirrin".toLowerCase() + ".dat";
        Scanner scan = new Scanner(new File(fileName));

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        String line;
        scan.nextLine();

        ArrayList<ArrayList<Character>> arr = new ArrayList<ArrayList<Character>>();
        for(int i = 0; i < rows; i++)
        {
            arr.add(new ArrayList<Character>());
            line = scan.nextLine();
            for(int j = 0; j < cols; j++)
            {
                arr.get(i).add((Character)(line.charAt(j)));
            }
        }

        //System.out.println(arr);
        /*if(arr.get(0).contains('-'))
        {
            for(int i = 0; i < )
        }*/

        boolean pipe = false;
        for(int i = 0; i < rows; i++) {
            if (arr.get(i).get(0) == '|') {
                //System.out.println("Pipe");
                pipe = true;
                break;
            }
        }
        int counter = 0;
        if(pipe == true)
        {
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols-2; j++) {
                    arr.get(i).add(0, ' ');
                }
            }
            for(int i = 0; i < rows; i++) {
                counter = 0;
                if(arr.get(i).get(cols-2) == '|') {
                    for (int j = arr.get(i).size() - 2; j > arr.get(i).size() - cols; j--) {
                        arr.get(i).set(counter, arr.get(i).get(j));
                        counter++;
                    }
                }
            }
        }
        boolean pipe2 = false;
        for(int i = 0; i < rows; i++) {
            if (arr.get(i).get(cols*2-3) == '|') {
                //System.out.println("Pipe2");
                pipe2 = true;
                break;
            }
        }
        if(pipe2 == true) {
            for(int i = 0; i < rows; i++) {
                counter = 0;
                if(arr.get(i).get(cols*2-3) == '|') {
                    for (int j = cols*2-4; j > cols-2; j--) {
                        arr.get(i).add(arr.get(i).get(j));
                    }
                }
            }
        }

        if(arr.get(0).contains('-'))
        {
            boolean[] t = new boolean[rows-2];
            //System.out.println(Arrays.toString(t));

            for(int i = 0; i < rows-2; i++)
            {
                if(arr.get(0).get(i+rows-1) == '-') {
                    t[i] = true;
                }

            }

            for(int i = 0; i < rows - 2; i++)
                arr.add(0, new ArrayList<Character>());

            for(int i = 0; i < rows-2; i++)
            {
                for(int j = 0; j < cols - 1; j++) {
                    arr.get(i).add(' ');
                }
                for(int j = 0; j<cols-2; j++)
                {
                    if(!t[j]) {
                        arr.get(i).add(' ');
                    }
                    else {
                        arr.get(i).add(arr.get(arr.size()-2-i).get(rows-1+j));
                    }
                }
            }
        }

        if(arr.get(arr.size()-1).contains('-'))
        {
            boolean[] t2 = new boolean[rows-2];
            //System.out.println(Arrays.toString(t));

            for(int i = 0; i < rows-2; i++)
            {
                if(arr.get(arr.size()-1).get(i+rows-1) == '-') {
                    t2[i] = true;
                }

            }

            for(int i = 0; i < rows - 2; i++)
                arr.add(new ArrayList<Character>());

            for(int i = 2*(rows-2)+2; i < 2*(rows-2)+rows; i++)
            {
                for(int j = 0; j < cols - 1; j++) {
                    arr.get(i).add(' ');
                }
                for(int j = 0; j<cols-2; j++)
                {
                    if(!t2[j]) {
                        arr.get(i).add(' ');
                    }
                    else {
                        arr.get(i).add(arr.get((2*(rows-2))+(2*(rows-2)+2 -i)).get(rows-1+j));
                    }
                }
            }
        }


        //System.out.println(arr.get(0).size());
        print2DArrayList(arr);

    }

    public static void print2DArray(char[][] in) {
        IntStream.range(0, in.length).forEach(e -> System.out.println(Arrays.toString(in[e]).replaceAll("[\\s,\\[\\]]", "")));
    }

    public static void print2DArrayList(ArrayList<ArrayList<Character>> arr)
    {
        for(int i = 0; i < arr.size(); i++)
        {
            for(int j = 0; j < arr.get(i).size(); j++)
            {
                System.out.print(arr.get(i).get(j));
            }
            System.out.println();
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