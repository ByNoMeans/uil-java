import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LongString {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("LongString.dat"));


        //https://www.geeksforgeeks.org/perimeter-of-convex-hull-for-a-given-set-of-points/
        scan.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        while (scan.hasNext()) {
            points.add(new Point(scan.nextInt(), scan.nextInt()));
        }

        Point BL = getSmallestXCoord(points);
        Point BR = getSmallestYCoord(points);
        Point TR = getLargestXCoord(points);
        Point TL = getLargestYCoord(points);

        ArrayList<Point> finalPath = new ArrayList<>();
        finalPath.add(BL);

        Point curr = BL;

        //Must figure out a way to order them so you sensibly progress from one to another; or nah?
        //Must account for "skipping" over a point; ignore it then

        while (true) {
            Point add = toTopLeft(points, finalPath, curr);
            Point lastInPath = finalPath.get(finalPath.size() - 1);
            if (add.getX() == lastInPath.getX() && add.getY() < lastInPath.getY())
                points.remove(add);
            else {
                finalPath.add(add);
                curr = add;
            }
            if (pointInList(finalPath, TL))
                break;
        }
        System.out.println(finalPath);
        //System.out.printf("%.2f", findStringLength(finalPath));

    }
    public static boolean pointInList(ArrayList<Point> points, Point point) {
        for (Point point1 : points)
            if (point1.equals(point))
                return true;
        return false;
    }

    public static double distance(Point one, Point two) {
        return Math.sqrt(Math.pow((one.getX() - two.getX()), 2) + Math.pow((one.getY() - two.getY()), 2));
    }

    //MAXIMUM_VALUE MAY NOT WORK FOR TOP AND BOTTOM AS SLOPE OF 0 IS SPECIAL CASE, AND UNDEFINED SLOPE MAY BE DIFFERENT
    public static double absoluteSlopeLeftRight(Point one, Point two) {
        int divisor = two.getX() - one.getX();
        return (divisor == 0) ? Double.MAX_VALUE : Math.abs(((double) two.getY() - one.getY()) / divisor);
    }

    //BOTTOM SPECIAL CASE; SHOULD MEET THE ORIGINAL POINT
    public static Point toTopLeft(ArrayList<Point> points, ArrayList<Point> visited, Point start) {
        Point p = new Point();
        double largestSlope = 0.0;
        for (Point point : points) {
            double prevSlope = largestSlope;
            largestSlope = !visited.contains(point) && point != start ? Math.max(absoluteSlopeLeftRight(point, start), largestSlope) : largestSlope;
            p = largestSlope > prevSlope ? point : p;
        }
        return p;
    }

    public static double findStringLength(ArrayList<Point> arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.size() - 1; ) {
            sum += distance(arr.get(i), arr.get(++i));
        }
        return sum + distance(arr.get(0), arr.get(arr.size() - 1));
    }

    //min x and min (BL)
    public static Point getSmallestXCoord(ArrayList<Point> arr) {
        int smallestX = Integer.MAX_VALUE;
        int smallestY = Integer.MAX_VALUE;
        for (Point p : arr)
            smallestX = Math.min(p.getX(), smallestX);

        for (Point p : arr) {
            if (p.getX() == smallestX)
                smallestY = Math.min(smallestY, p.getY());
        }

        return new Point(smallestX, smallestY);
    }

    //max x, max y (TR)
    public static Point getLargestXCoord(ArrayList<Point> arr) {
        int largestX = Integer.MIN_VALUE;
        int largestY = Integer.MIN_VALUE;
        for (Point p : arr)
            largestX = Math.max(p.getX(), largestX);

        for (Point p : arr) {
            if (p.getX() == largestX) {
                largestY = Math.max(largestY, p.getY());
            }
        }
        return new Point(largestX, largestY);
    }

    //max x, min y (BR)
    public static Point getSmallestYCoord(ArrayList<Point> arr) {
        int largestX = Integer.MIN_VALUE;
        int smallestY = Integer.MAX_VALUE;
        for (Point p : arr)
            smallestY = Math.min(p.getY(), smallestY);

        for (Point p : arr) {
            if (p.getY() == smallestY)
                largestX = Math.max(largestX, p.getX());
        }
        return new Point(largestX, smallestY);
    }

    //min x, max y (TL)
    public static Point getLargestYCoord(ArrayList<Point> arr) {
        int smallestX = Integer.MAX_VALUE;
        int largestY = Integer.MIN_VALUE;
        for (Point p : arr)
            largestY = Math.max(p.getY(), largestY);

        for (Point p : arr) {
            if (p.getY() == largestY)
                smallestX = Math.min(smallestX, p.getX());
        }
        return new Point(smallestX, largestY);
    }


}}
