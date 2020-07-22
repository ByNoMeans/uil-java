import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Family {
    public static void main(String[] args) throws IOException {
        String barrettPath = "C:\\Users\\barre\\Github\\uil-java\\past-competitions\\2013-1\\SampleData\\family.dat";
        String sidPath = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-1/SampleData/family.dat";
        Scanner scan = new Scanner(new File(sidPath));

        List<String> list = new ArrayList<>();
        while (scan.hasNextLine()) {list.add(scan.nextLine());}
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        int gen = 1;

        for (int i = 0; i < list.size(); i++) {
            String[] line = list.get(i).split("\\s");
            String s = line[0], r = line[1], d = line[2];
            if (r.equals("FATHER") || r.equals("MOTHER")) {
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if (list.get(j).contains(String.format("%s %s",r,s)))
                        count++;
                }
                map.put(s,count+1);
                map.put(d,i==0 ? ++gen : gen++);
            } else {
                map.put(s,gen);
                map.put(d,gen);
            }
        }

        List<Integer> values = new ArrayList<>();
        map.values().stream().distinct().forEach(values::add);
        Collections.sort(values);

        for (int v : values) {
            StringBuilder genString = new StringBuilder();
            List<String> kList = new ArrayList<>();
            map.forEach( (k, va) -> {
                if (va == v) kList.add(k);
            });
            Collections.sort(kList);
            for (String s : kList) genString.append(s).append(" ");
            System.out.printf("%d%s Generation: %s\n",v,v == 1 ? "st" : v == 2 ? "nd" : v == 3 ? "rd" : "th", genString.toString().trim());
        }
    }
}
