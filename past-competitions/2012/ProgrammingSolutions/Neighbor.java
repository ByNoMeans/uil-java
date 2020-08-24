package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Neighbor {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\judges\\neighbor.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            int minSize = Integer.parseInt(s.nextLine());
            int rows = s.nextInt();
            int cols = s.nextInt();
            s.nextLine();
            String[][] matrix = new String[rows][];
            for(int r = 0; r < rows; r++) {
                String[] data = s.nextLine().trim().split("\\s+");
                assert data.length == cols;
                matrix[r] = data;
            }
            
            int fn = countNeigh(getCopy(matrix), minSize, fourNeighs, false);
            int fw = countNeigh(getCopy(matrix), minSize, fourNeighs, true);
            int en = countNeigh(getCopy(matrix), minSize, eightNeighs, false);
            int ew = countNeigh(getCopy(matrix), minSize, eightNeighs, true);
            System.out.println(fn + " " + fw + " " + en + " " + ew);
        }
        s.close();
    }
    
    
    
    private static String[][] getCopy(String[][] matrix) {
        String[][] result = new String[matrix.length][];
        for(int r = 0; r < result.length; r++)
            result[r] = matrix[r].clone();
        return result;
    }



    static int[][] fourNeighs = {{-1, 0, 1, 0}, {0, 1, 0, -1}};
    static int[][] eightNeighs = {{-1, -1, -1, 0, 0, 1, 1, 1}, {-1, 0, 1, -1, 1, -1, 0, 1}};
    
    final static String EMPTY = " ";
    
    public static int countNeigh(String[][] matrix, int min, int[][] neighs, boolean wrap) {
        int result = 0;
        for(int r = 0; r < matrix.length; r++)
            for(int c = 0; c < matrix[0].length; c++)
                if(!matrix[r][c].equals(EMPTY) && sizeOfNeigh(matrix, r, c, matrix[r][c], neighs, wrap) >= min)
                    result++;
        return result;
    }

    private static int sizeOfNeigh(String[][] matrix, int r, int c, String tgt,
           int[][] neighs, boolean wrap) {
        if(!inbounds(matrix, r,c))
            return 0;
        else if(!matrix[r][c].equals(tgt))
            return 0;
        else {
            int result = 1;
            matrix[r][c] = EMPTY;
            for(int i = 0; i < neighs[0].length; i++) {
                int newRow = r + neighs[0][i];
                int newCol = c + neighs[1][i];
                if(wrap) {
                    newRow = (newRow + matrix.length) % matrix.length;
                    newCol = (newCol + matrix[r].length) % matrix[r].length;
                }
                result += sizeOfNeigh(matrix, newRow, newCol, tgt, neighs, wrap);
            }
            return result;
        }
    }



    private static boolean inbounds(String[][] matrix, int r, int c) {
        return 0 <= r && r < matrix.length && 0 <= c && c < matrix[r].length;
    }
}