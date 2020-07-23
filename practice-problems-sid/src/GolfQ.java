import java.math.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;
import java.text.*;

public class GolfQ {
    public static void main(String[] args) throws IOException {
        String fileName = "/Users/sidbaskaran/Desktop/uil-java/past-competitions/2013-2/SampleData/";
        Scanner in = new Scanner(new File(fileName + "GolfQ".toLowerCase() + ".dat"));
        int lines = in.nextInt();
        in.nextLine();

        List<String> list = new ArrayList<>(), finalList = new ArrayList<>();
        for (int i = 0; i < lines; i++) list.add(in.nextLine());
        list.stream().filter(x -> Integer.parseInt(x.split("\\s")[2]) <= Integer.parseInt(list.get(11).split("\\s")[2])).forEach(finalList::add);
        finalList.forEach(x -> System.out.printf("%s %s\n",x.split("\\s")[0],x.split("\\s")[1]));
    }
}