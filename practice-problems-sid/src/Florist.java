import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class Florist {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-2/SampleData/";
        Scanner in = new Scanner(new File(fileName + "Florist".toLowerCase() + ".dat"));

        List<Integer> weights = Arrays.stream(in.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
        int lines = in.nextInt();
        in.nextLine();

        for (int i = 0; i < lines; i++) {
            List<Integer> currLimits = new ArrayList<>(weights);
            List<Integer> plantWeights = Arrays.stream(in.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
            Collections.sort(currLimits); Collections.sort(plantWeights);
            int count = 0;
            Iterator<Integer> lim = currLimits.iterator();
            for (int j = 0; j < plantWeights.size(); j++) {
                while (lim.hasNext()) {
                    if (plantWeights.get(j) <= lim.next()) {
                        plantWeights.remove(j); j--;
                        lim.remove();
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count);
        }
    }
}