import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Emmanuel {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("emmanuel.dat"));
        int sets = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < sets; i++){
            String nSet = scan.nextLine();
            String s = nSet.replaceAll(","," ");
            String[] fix = s.substring(1, s.length()-1).split(" ");
            int[] arr = new int[fix.length];
            int z = 0;
            for (String x : fix) {
                arr[z] = Integer.valueOf(x);
                z++;
            }
            if (arr.length > 1) {
                int mode = mode(arr);
                int count = 0;
                for (int x : arr) {
                    if (x == mode)
                        count++;
                }
                System.out.println(mode + " appeared " + count +" time(s)");

            }
            else
                System.out.println(arr[0] + " appeared 1 time(s)");
        }
    }
    public static int mode(int []array)
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int max  = 1;
        int temp = 0;

        for(int i = 0; i < array.length; i++) {

            if (hm.get(array[i]) != null) {

                int count = hm.get(array[i]);
                count++;
                hm.put(array[i], count);

                if(count > max) {
                    max  = count;
                    temp = array[i];
                }
            }

            else
                hm.put(array[i],1);
        }
        return temp;
    }

    public static double distance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow(x2-x1, 2));
    }

}
