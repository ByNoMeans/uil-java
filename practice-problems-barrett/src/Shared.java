import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Shared {
    public static void main(String[] args) throws IOException {
//        Scanner scan = new Scanner(new File("..\\past-competitions\\2010\\SampleData\\" + "shared.dat"));
//        int lines = scan.nextInt();
//        scan.nextLine();
//        for (int i = 0; i < lines; i++) {
//            LinkedHashMap<Integer, Point> r1 = generateRectangle(scan);
//            LinkedHashMap<Integer, Point> r2 = generateRectangle(scan);
//            System.out.println(generateArea(obtainPt(r1, r2), obtainPt(r2, r1)));
//        }

    }

    static LinkedHashMap<Integer, Point> generateRectangle(Scanner scan) {
        LinkedHashMap<Integer, Point> out = new LinkedHashMap<>();
        for (int j = 0; j < 2; j++)
            out.put(j, new Point(scan.nextInt(), scan.nextInt()));
        return out;
    }

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point obtainPt(LinkedHashMap<Integer, Point> r1 ,LinkedHashMap<Integer, Point> r2) {
        for (int i = 0; i < r1.size(); i++)
            if (isInside(r1.get(i), r2))
                return r1.get(i);
        return null;
    }

    static boolean isInside(Point a, LinkedHashMap<Integer, Point> r) {
        return a.x > r.get(0).x && a.y > r.get(0).y && a.x < r.get(3).x && a.y < r.get(3).y;
    }

    static int generateArea(Point one, Point two) {
        return Math.abs(one.x - two.x) * Math.abs(one.y - two.y);
    }
}