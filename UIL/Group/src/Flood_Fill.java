public class Flood_Fill {

    // Recursive function to replace pCol at xCor, yCor with newCol
    public static void helper(int[][] arr, int width, int height, int x, int y, int pCol, int newCol) {

        // base case to stop out of bounds and infinite recursion
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return;
        }

        // you only want to replace the colors that are the same as the original, not different; then everything would
        // be the same color; you return null because if you didn't, and just skip over the color, it would continue to
        // call floodfill on surrounding cells

        //below is the base case to stop infinite recursion (color you're on is not the color that should be replaced)
        if (arr[x][y] != pCol) {
            return;
        }

        arr[x][y] = newCol;

        helper(arr, width, height, x + 1, y, pCol, newCol);
        helper(arr, width, height, x - 1, y, pCol, newCol);
        helper(arr, width, height, x, y + 1, pCol, newCol);
        helper(arr, width, height, x, y - 1, pCol, newCol);

    }

    static void floodFill(int[][] arr, int width, int height, int x, int y, int newCol) {

        if (x < 0 || x >= width || y < 0 || y >= height) {
            System.out.println("Coordinates given not in array; returning unchanged array");
            return;
        }

        int pCol = arr[x][y];
        helper(arr, x, y, width, height, pCol, newCol);

    }

    public static void main(String[] args) {
        int width = 8; int height = 8;
        int arr[][] =  {{1, 1, 1, 1, 1, 1, 1, 1},
                        {1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 0, 0, 1, 1, 0, 1, 1},
                        {1, 2, 2, 2, 2, 0, 1, 0},
                        {1, 1, 1, 2, 2, 0, 1, 0},
                        {1, 1, 1, 2, 2, 2, 2, 0},
                        {1, 1, 1, 1, 1, 2, 1, 1},
                        {1, 1, 1, 1, 1, 2, 2, 1},
        };

        int x = 12, y = 4, newC = 3;
        floodFill(arr, width, height, x, y, newC);

        System.out.println("Updated screen after call to floodFillon point (" + x + ", " + y +  ") "
         + "with color " + newC + ":");

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}

