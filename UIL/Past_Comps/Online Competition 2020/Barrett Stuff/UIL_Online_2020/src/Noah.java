import java.util.*;
import java.io.*;
import java.lang.*;

public class Noah {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("noah.dat"));
        int lines = scan.nextInt();
        scan.nextLine();

        ArrayList<String> str =new ArrayList<>();
        ArrayList<Integer> done =new ArrayList<>();
        for (int i = 0; i < lines; i++) {
            String[] arr = scan.nextLine().split(",");
            String model = arr[0] + " " + arr[1] + " " + arr[2];
            str.add(model);
        }

        for (int z = 0; z < 3; z++) {
            if (z == 0) {
                System.out.println("---Data Sorted---");
                Collections.sort(str);
                for (String x : str)
                    System.out.println(x + " ");
                System.out.println();
            } else {
                if (z == 1)
                    System.out.println("---Make Breakdown---");
                else
                    System.out.println("---Model Breakdown---");
                LinkedHashMap<String, Integer> d = new LinkedHashMap<>();
                for (String x : str) {
                    String key = x.split(" ")[z];
                    if (!d.containsKey(key))
                        d.put(key, 1);
                    else
                        d.put(key, Integer.valueOf("" + (d.get(key) + 1)));
                }
                for (String  name: d.keySet()){
                    String key = name;
                    String value = d.get(name).toString();
                    System.out.println(key + ": " + value);
                }
                System.out.println();
            }
        }
    }
}
