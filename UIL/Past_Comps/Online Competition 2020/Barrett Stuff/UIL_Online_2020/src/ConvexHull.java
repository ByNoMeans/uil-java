import org.jetbrains.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(@NotNull Point p) {
        if (this.x == p.x)
            return this.y - p.y;
        else
            return this.x - p.x;
    }

}

public class ConvexHull {

    public static long cross(Point O, Point A, Point B) {
        return (A.x - O.x) * (long) (B.y - O.y) - (A.y - O.y) * (long) (B.x - O.x);
    }
    public static Point[] convex_hull(Point[] P) {
        if (P.length > 1) {
            int n = P.length, k = 0;
            Point[] H = new Point[2 * n];
            Arrays.sort(P);
            for (Point point : P) {
                while (k >= 2 && cross(H[k - 2], H[k - 1], point) <= 0)
                    k--;
                H[k++] = point;
            }
            for (int i = n - 2, t = k + 1; i >= 0; i--) {
                while (k >= t && cross(H[k - 2], H[k - 1], P[i]) <= 0)
                    k--;
                H[k++] = P[i];
            }
            if (k > 1)
                H = Arrays.copyOfRange(H, 0, k - 1);
            return H;
        } else
            return P;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("LongString.dat"));
        int size = scan.nextInt() + 1;
        Point[] p = new Point[size];
        for (int i = 0; i < p.length; i++)
            p[i] = new Point(scan.nextInt(), scan.nextInt()) ;
        Point[] hull = convex_hull(p).clone();
        ArrayList<Point> points = new ArrayList<>();
        for (Point point : hull)
            if (point != null)
                points.add(point);
        System.out.printf("%.2f", findStringLength(points));
    }
    public static double findStringLength(ArrayList<Point> arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.size() - 1; )
            sum += distance(arr.get(i), arr.get(++i));
        return sum + distance(arr.get(0), arr.get((arr.size()) - 1));
    }
    public static double distance(Point one, Point two) {
        return Math.sqrt(Math.pow((one.x - two.x), 2) + Math.pow((one.y - two.y), 2));
    }
}