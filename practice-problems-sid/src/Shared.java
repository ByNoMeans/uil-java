import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Shared {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(new File("/Users/sidbaskaran/Desktop/uil-compsci/uil-java/past-competitions/2010/SampleData/shared.dat"));

        int lines = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < lines; i++) {
            LinkedHashMap<Integer, Point> r1 = new LinkedHashMap<>();
            for (int j = 0; j < 2; j++) {
                r1.put(j, new Point(scan.nextInt(), scan.nextInt()));
            }
            r1.put(2, new Point(r1.get(0).x, r1.get(1).y));
            r1.put(3, new Point(r1.get(1).x, r1.get(0).y));
            scan.nextLine();
            LinkedHashMap<Integer, Point> r2 = new LinkedHashMap<>();
            for (int j = 0; j < 2; j++) {
                r2.put(j, new Point(scan.nextInt(), scan.nextInt()));
            }
            r2.put(2, new Point(r2.get(0).x, r2.get(1).y));
            r2.put(3, new Point(r2.get(1).x, r2.get(0).y));
            Point pt1 = obtainPt(r1, r2);
            Point pt2 = obtainPt(r2, r1);
            System.out.println(generateArea(pt1, pt2));
        }


    }
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static Point obtainPt(LinkedHashMap<Integer, Point> r1 , LinkedHashMap<Integer, Point> r2) {
        Point out = null;
        for (int i = 0; i < r1.size(); i++) {
            if (isInside(r1.get(i), r2))
                out = r1.get(i);
        }
        return out;
    }

    // if point is inside rectangle
    static boolean isInside(Point a, LinkedHashMap<Integer, Point> r) {
        return a.x > r.get(0).x && a.y > r.get(0).y && a.x < r.get(3).x && a.y < r.get(2).y;
    }

    static int generateArea(Point one, Point two) {
        int area = 0;
        return Math.abs(one.x - two.x) * Math.abs(one.y - two.y);
    }
}