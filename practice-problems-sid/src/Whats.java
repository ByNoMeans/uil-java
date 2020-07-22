import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class Whats {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-1/SampleData/";
        Scanner in = new Scanner(new File(fileName + "Whats".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        for (int i = 0; i < lines; i++) {
            List<Integer> line = new ArrayList<>();
            Arrays.stream(in.nextLine().split("\\s")).forEach(s -> {
                line.add(Integer.parseInt(s));
            });
            List<Integer> abs = new ArrayList<>(), idx = new ArrayList<>();
            IntStream.range(0,line.size()-1).forEach(d -> {
                abs.add(line.get(d+1)-line.get(d));
                idx.add(d+1);
            });
            LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
            IntStream.range(0,abs.size()).forEach(d -> {
                map.put(abs.get(d),idx.get(d));
            });
            List<Integer> mapValues = new ArrayList<>(map.keySet());
            Collections.sort(mapValues);
            IntStream.range(0,4).forEach(d -> {
                System.out.printf("%d %d\n",mapValues.get(d),map.get(mapValues.get(d)));
            });
            System.out.println();
        }
    }
}