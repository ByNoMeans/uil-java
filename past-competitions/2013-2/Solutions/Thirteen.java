import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Thirteen {

	public static final boolean bDebug = false;
	
	public static final int SIZE			= 10;
	
	public static final char CELL_JEWEL		= '*';
	public static final char CELL_OBSTACLE	= '#';
	public static final char CELL_EMPTY		= '.';
	public static final char CELL_START		= 'S';
	public static final char CELL_EXIT		= 'E';
	
	// Ways to limit recursion
	public static final char CELL_VISITED	= '@';
	
	
	public static class Pos {
		public int x = 0;
		public int y = 0;
		
		public Pos(int r, int c) {
			x = r;
			y = c;
		}
		
		public boolean isValid() {
			return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
		}
	}
	
	
	public static int recurse(char[][] grid, final Pos curPos, int collected, int recurseDepth) {
		if (!curPos.isValid()) {
			return Integer.MAX_VALUE;
		}
		
		if (collected > 13) {
			System.out.println("You suck at math!");
			return Integer.MAX_VALUE;
		}
		
		if (bDebug) {
			for (int i = 0; i < recurseDepth - 1; ++i) {
				System.out.print(".");
			}
			System.out.printf("Checking %d %d\n", curPos.x, curPos.y);
		}
		
		final char curCh = grid[curPos.x][curPos.y];
		if (curCh == CELL_VISITED || curCh == CELL_OBSTACLE) {
			return Integer.MAX_VALUE;
		}
		else if (curCh == CELL_EXIT) {
			return collected == 13 ? 1 : Integer.MAX_VALUE;
		}
		else if (curCh == CELL_JEWEL) {
			++collected;
		}
		
		grid[curPos.x][curPos.y] = CELL_VISITED;
		
		int min = Integer.MAX_VALUE;
		min = Math.min(min, recurse(grid, new Pos(curPos.x - 1, curPos.y + 0), collected, recurseDepth + 1));
		min = Math.min(min, recurse(grid, new Pos(curPos.x + 1, curPos.y + 0), collected, recurseDepth + 1));
		
		min = Math.min(min, recurse(grid, new Pos(curPos.x + 0, curPos.y - 1), collected, recurseDepth + 1));
		min = Math.min(min, recurse(grid, new Pos(curPos.x + 0, curPos.y + 1), collected, recurseDepth + 1));
		
		grid[curPos.x][curPos.y] = curCh;
		
		return min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
	}
	
	public static void main(String args[]) throws IOException {
		Scanner kb = new Scanner(new File("thirteen.dat"));
		
		int numGrids = Integer.parseInt(kb.nextLine().trim());
		for (int i = 0; i < numGrids; ++i) {
			char[][] grid = new char[SIZE][SIZE];
			
			for (int r = 0; r < SIZE; ++r) {
				String line = kb.nextLine().trim();
				for (int c = 0; c < SIZE; ++c) {
					grid[r][c] = line.charAt(c);
				}
			}
			
			int seconds = recurse(grid, new Pos(0, 0), 0, 1);
			System.out.printf("%d\n", seconds - 1);
		}
	}	
}
