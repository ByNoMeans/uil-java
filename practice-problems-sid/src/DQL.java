import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DQL {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-2/SampleData/";
        Scanner in = new Scanner(new File(fileName + "DQL".toLowerCase() + ".dat"));

        int c = in.nextInt(), r = in.nextInt(); in.nextLine();
        List<String> hdr = Arrays.asList(in.nextLine().split("\\s"));
        List<List<String>> db = new ArrayList<>();
        IntStream.range(0,r).forEach(i -> db.add(Arrays.asList(in.nextLine().split("\\s"))));

        int q = in.nextInt(); in.nextLine();
        for (int i = 0; i < q; i++) {
            String[] query = in.nextLine().replaceAll("(SELECT)|(\\s)","")
                    .replaceAll("WHERE"," ").split("\\s");
            System.out.printf("Query #%d%n",i+1);

            String[] select = query[0].split(",");
            List<List<String>> out = new ArrayList<>();
            int reqIdx = 0;
            for (String h : hdr) {
                if (query[1].contains(h))
                    reqIdx = hdr.indexOf(query[1].replaceAll(String.format("[^%s]",h),""));
            }
            String val1 = query[1].replaceAll("\\w*(([<>])|(.=))","");

            if (query[0].equals("*")) {
                if (!query[1].equals(" ")) {
                    for (int n = 0; n < r; n++) {
                        for (int m = 0; m < hdr.size(); m++) {
                            //System.out.printf("%d %d %s %s%n",m,n,query[1],val1);
                            out.add(findInDB(db,m,n,query[1],val1));
                        }
                    }
                } else {
                    for (int n = 0; n < r; n++) {
                        out.add(findInDB(db,reqIdx,n,query[1],val1));
                    }
                }
                System.out.println(out);
                printOutput(out);
            }

            for (String arg : select) {
                int idx = hdr.indexOf(arg);
                out.add(findInDB(db,reqIdx,idx,query[1],val1));
                //System.out.printf("%d %d %s %s%n",reqIdx,idx,query[1],val1);
            }
            printOutput(out);
        }
    }

    public static void printOutput(List<List<String>> out) {
        IntStream.range(0,out.get(0).size()).forEach(x -> {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < out.size(); j++) {
                s.append(out.get(j).get(x)).append(j == out.size() -1 ? "" : " ");
            }
            if (s.toString().isBlank())
                System.out.println("NONE");
            else
                System.out.println(s.toString());
        });
    }

    public static List<String> findInDB(List<List<String>> db, int reqIdx, int argIdx, String where, String param) {
        int p;
        try  {
            p = Integer.parseInt(param);
        } catch (NumberFormatException ignored) {
            p = 0;
        }
        //System.out.printf("reqidx: %d argidx: %d%n",reqIdx, argIdx);
        List<String> res = new ArrayList<>();
        if (where.contains("<")) {
            for (List<String> list : db) {
                if (Integer.parseInt(list.get(reqIdx)) < p)
                    res.add(list.get(argIdx));
            }
        } else if (where.contains(">")) {
            for (List<String> list : db) {
                if (Integer.parseInt(list.get(reqIdx)) > p)
                    res.add(list.get(argIdx));
            }
        } else if (where.contains("<=")) {
            for (List<String> list : db) {
                if (Integer.parseInt(list.get(reqIdx)) <= p)
                    res.add(list.get(argIdx));
            }
        } else if (where.contains(">=")) {
            for (List<String> list : db) {
                if (Integer.parseInt(list.get(reqIdx)) >= p)
                    res.add(list.get(argIdx));
            }
        } else {
            if (p != 0) {
                for (List<String> list : db) {
                    //System.out.println(list);
                    if (Integer.parseInt(list.get(reqIdx)) == p)
                        res.add(list.get(argIdx));
                }
            } else {
                for (List<String> list : db) {
                    //System.out.println(reqIdx);
                    if (list.get(reqIdx).equals(param))
                        res.add(list.get(argIdx));
                }
            }
        }
        return res;
    }
}