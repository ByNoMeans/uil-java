import org.jetbrains.annotations.*;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class methods {
    public static final String SYMBOLS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static void print2DArray(Object[][] in) {
        Stream.of(in.forEach(e -> {
            System.out.println(Arrays.toString(e));
        }));
    }

    static class ShortestPath {
        static int ROW = 9;
        static int COL = 10;

        static class BFSPoint {
            int x;
            int y;

            public BFSPoint(int x, int y)
            {
                this.x = x;
                this.y = y;
            }
        }

        static class queueNode {
            BFSPoint pt;
            int dist;

            public queueNode(BFSPoint pt, int dist)
            {
                this.pt = pt;
                this.dist = dist;
            }
        }

        static boolean isValid(int row, int col) {
            return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
        }

        static int[] rowNum = {-1, 0, 0, 1};
        static int[] colNum = {0, -1, 1, 0};

        static int BFS(int[][] mat, BFSPoint src, BFSPoint dest) {
            if (mat[src.x][src.y] != 1 || mat[dest.x][dest.y] != 1)
                return -1;

            boolean[][] visited = new boolean[ROW][COL];

            visited[src.x][src.y] = true;

            Queue<queueNode> q = new LinkedList<>();

            queueNode s = new queueNode(src, 0);
            q.add(s);

            while (!q.isEmpty()) {
                queueNode curr = q.peek();
                BFSPoint pt = curr.pt;
                if (pt.x == dest.x && pt.y == dest.y)
                    return curr.dist;
                q.remove();

                for (int i = 0; i < 4; i++) {
                    int row = pt.x + rowNum[i];
                    int col = pt.y + colNum[i];
                    if (isValid(row, col) && mat[row][col] == 1 && !visited[row][col]) {
                        visited[row][col] = true;
                        queueNode Adjcell = new queueNode(new BFSPoint(row, col), curr.dist + 1 );
                        q.add(Adjcell);
                    }
                }
            }
            return -1;
        }
		/*public static void main(String[] args)
		{
            char[][] maze = new maze[length][width];
		    BFSPoint source = new BFSPoint(startx, starty);
		    BFSPoint dest = new BFSPoint(endx, endy);

		    int dist = BFS(maze, source, dest);

		    if (dist != Integer.MAX_VALUE)
		        System.out.println("Shortest Path is " + dist);
		    else
		        System.out.println("Shortest Path doesn't exist");
		} */
    }

    public static String toInputBase(int inputNum, int base) {
        StringBuilder s = new StringBuilder();
        while (inputNum > 0) {
            s.append(SYMBOLS.charAt(inputNum % base));
            inputNum /= base;
        }
        return new String(s.reverse());
    }

    public static double distance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow((y2 - y1), 2) + Math.pow(x2 - x1, 2));
    }

    public static int hammingDistance(long n1, long n2) {
        long l = Long.parseLong("" + BigInteger.valueOf(n1).xor(BigInteger.valueOf(n2)));
        int setBits = 0;
        while (l > 0) {
            setBits += l & 1;
            l >>= 1;
        }
        return setBits;
    }

    public static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Removed @NotNull annotation; found at package org.jetbrains.annotations
        public int compareTo(Point p) {
            if (this.x == p.x)
                return this.y - p.y;
            else
                return this.x - p.x;

        }
    }

    public class Dates {
        /*
        public static String DATE_MMDDYYY_FORMAT {
            for (int i = 0; i < lines; i++) {
                String date = scan.next();
                int daysAfter = scan.nextInt();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                Calendar c = Calendar.getInstance();
                c.setTime(sdf.parse(date));
                c.add(Calendar.DAY_OF_MONTH, daysAfter);
                String out = sdf.format(c.getTime());
            }
        }
        */
    }

    public static class ConvexHull {
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

    public static class Statistics {
        public static int mode(ArrayList<String> array) {
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            int max = 1;
            String temp = "";
            for (int i = 0; i < array.size(); i++) {
                if (hm.get(array.get(i)) != null) {
                    int count = hm.get(array.get(i));
                    count++;
                    hm.put(array.get(i), count);

                    if (count > max) {
                        max = count;
                        temp = array.get(i);
                    }
                } else
                    hm.put(array.get(i), 1);
            }
            return Integer.parseInt(temp);
        }
    }

    public static long LCM(ArrayList<Integer> arr) {
        long lcm = 1;
        int divisor = 2;
        while (true) {
            int counter = 0;
            boolean divisible = false;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == 0)
                    return 0;
                else if (arr.get(i) < 0)
                    arr.set(i, arr.get(i) * -1);
                if (arr.get(i) == 1)
                    counter++;
                if (arr.get(i) % divisor == 0) {
                    divisible = true;
                    arr.set(i, arr.get(i) / divisor);
                }
            }
            if (divisible)
                lcm *= divisor;
            else
                divisor++;
            if (counter == arr.size())
                return lcm;
        }
    }

    /*
    Implementation
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File("LongString.dat"));
        int size = scan.nextInt() + 1;
        Point[] p = new Point[size];
        for (int i = 0; i < p.length; i++)
            p[i] = new Point(scan.nextInt(), scan.nextInt());
        Point[] hull = convex_hull(p).clone();
        ArrayList<Point> points = new ArrayList<>();
        for (Point point : hull)
            if (point != null)
                points.add(point);
        System.out.printf("%.2f", findStringLength(points));
    }
    */

    public static Integer[] toIntegerArr(int[] arr) {
        Integer[] ret = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }

    public static class ASCII_MAZE {
        public static boolean ASCII_MAZE_BASIC(int sx, int sy, int ex, int ey, char[][] maze, boolean[][] visited, boolean[][] correct, char wall) {
            if (sx == ex && sy == ey) return true;
            if (maze[sx][sy] == wall || visited[sx][sy]) return false;
            visited[sx][sy] = true;

            if (sx != 0)
                if (ASCII_MAZE_BASIC(sx - 1, sy, ex, ey, maze, visited, correct, wall)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sx != maze[0].length - 1)
                if (ASCII_MAZE_BASIC(sx + 1, sy, ex, ey, maze, visited, correct, wall)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sy != 0)
                if (ASCII_MAZE_BASIC(sx, sy - 1, ex, ey, maze, visited, correct, wall)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sy != maze.length - 1) {
                if (ASCII_MAZE_BASIC(sx, sy + 1, ex, ey, maze, visited, correct, wall)) {
                    correct[sx][sy] = true;
                    return true;
                }
            }
            return false;
        }

        public static boolean ASCII_MAZE_ENERGY(int sx, int sy, int ex, int ey, char[][] maze, boolean[][] visited, boolean[][] correct, char wall, int energy) {
            if (sx == ex && sy == ey && energy >= 0) return true;
            if (maze[sx][sy] == wall || visited[sx][sy] || energy <= 0) return false;
            visited[sx][sy] = true;
            if (maze[sx][sy] == '.') energy--;
            if (maze[sx][sy] == '*') energy -= 5;
            if (sx != 0)
                if (ASCII_MAZE_ENERGY(sx - 1, sy, ex, ey, maze, visited, correct, wall, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sx != maze[0].length - 1)
                if (ASCII_MAZE_ENERGY(sx + 1, sy, ex, ey, maze, visited, correct, wall, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sy != 0)
                if (ASCII_MAZE_ENERGY(sx, sy - 1, ex, ey, maze, visited, correct, wall, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            if (sy != maze.length - 1) {
                if (ASCII_MAZE_ENERGY(sx, sy + 1, ex, ey, maze, visited, correct, wall, energy)) {
                    correct[sx][sy] = true;
                    return true;
                }
            }
            return false;
        }
    }

    public static class Flood_Fill {
        public static void floodFillHelper(int[][] arr, int width, int height, int x, int y, int fCol, int newColor) {
            if (x < 0 || x >= width || y < 0 || y >= height)
                return;
            if (arr[x][y] != fCol)
                return;
            arr[x][y] = newColor;
            floodFillHelper(arr, width, height, x + 1, y, fCol, newColor);
            floodFillHelper(arr, width, height, x - 1, y, fCol, newColor);
            floodFillHelper(arr, width, height, x, y + 1, fCol, newColor);
            floodFillHelper(arr, width, height, x, y - 1, fCol, newColor);
        }

        public static void floodFill(int[][] arr, int width, int height, int x, int y, int newColor) {
            if (x < 0 || x >= width || y < 0 || y >= height) {
                System.out.println("Coordinates given not in array; returning unchanged array");
                return;
            }
            int pCol = arr[x][y];
            floodFillHelper(arr, x, y, width, height, pCol, newColor);
        }
    }

    public static char[][] process2DASCII(Scanner scan, int length, int width) {
        char[][] out = new char[length][width];
        for (int i = 0; i < length; i++) {
            String line = scan.nextLine();
            for (int j = 0; j < width; j++) 
                out[i][j] = line.charAt(j);
        }
        return out;
    }
}