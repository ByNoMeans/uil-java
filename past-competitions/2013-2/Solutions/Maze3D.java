import java.io.*;
import java.util.*;

public class Maze3D
{
	public static final char kCellEmpty			= '.';
	public static final char kCellAsteroid		= '#';
	public static final char kCellDebris		= '*';
	public static final char kCellStart			= 'S';
	public static final char kCellExit			= 'E';
	public static final char kCellVisited		= '@';
	
	public static final char kNumStartingShots	= 3;
	
	public static class MathVector {
		public int r;
		public int c;
		public int f;
		
		public MathVector(int inR, int inC, int inF) {
			r = inR;
			c = inC;
			f = inF;
		}
		
		public MathVector() {
			r = c = f = 0;
		}
	}
	
	public static char[][][] maze;
	public static int numShots;
	public static MathVector startPos;
	public static MathVector exitPos;
	
	public static int recurse(MathVector curPos) {
		if (curPos.r < 0 || curPos.r >= maze.length) {
			return 0;
		}
		
		if (curPos.c < 0 || curPos.c >= maze[0].length) {
			return 0;
		}
		
		if (curPos.f < 0 || curPos.f >= maze[0][0].length) {
			return 0;
		}
		
		int moves = 0;
		char ch = maze[curPos.r][curPos.c][curPos.f];
		
		maze[curPos.r][curPos.c][curPos.f] = kCellVisited;
		if (ch != kCellAsteroid) {
			if (ch == kCellExit) {
				++moves;
			}
			else if (ch == kCellDebris) {
				if (numShots > 0) {
					--numShots;
					int withShot = recurse2(curPos);
					++numShots;
					
					if (withShot > 0) {
						moves = 1 + withShot;
					}
				}
			}
			else if (ch != kCellVisited) {
				int m = recurse2(curPos);
				if (m > 0) {
					if (ch != kCellStart) {
						++moves;
					}
					
					moves += m;
				}
			}
		}
		maze[curPos.r][curPos.c][curPos.f] = ch;
		
		return moves;
	}
	
	public static int recurse2(MathVector curPos) {
		int[] values = new int[6];
		// row
		values[0] = recurse(new MathVector(curPos.r - 1, curPos.c, curPos.f));
		values[1] = recurse(new MathVector(curPos.r + 1, curPos.c, curPos.f));
		
		// col
		values[2] = recurse(new MathVector(curPos.r, curPos.c - 1, curPos.f));
		values[3] = recurse(new MathVector(curPos.r, curPos.c + 1, curPos.f));
		
		// floor
		values[4] = recurse(new MathVector(curPos.r, curPos.c, curPos.f - 1));
		values[5] = recurse(new MathVector(curPos.r, curPos.c, curPos.f + 1));
		
		// For the sake of quick typing, bubble sort!
		for (int x = 0; x < 6; ++x) {
			for (int y = x + 1; y < 6; ++y) {
				int xVal = values[x];
				int yVal = values[y];
				
				if (xVal > yVal) {
					values[x] = yVal;
					values[y] = xVal;
				}
			}
		}
		
		for (int x = 0; x < 6; ++x) {
			if (values[x] > 0) {
				return values[x];
			}
		}
		
		return 0;
	}
	
	public static void main(String args[]) throws IOException {
    	Scanner kb = new Scanner(new File("maze3d.dat"));
    	
    	int numMazes = Integer.parseInt(kb.nextLine().trim());
    	for (int m = 0; m < numMazes; ++m) {
    		String[] sizes = kb.nextLine().trim().split(" ");
    		int rows = Integer.parseInt(sizes[0]);
    		int cols = Integer.parseInt(sizes[1]);
    		int floors = Integer.parseInt(sizes[2]);
    		
    		maze = new char[rows][cols][floors];
    		numShots = kNumStartingShots;
    		
    		startPos = null;
    		exitPos = null;
    		
    		for (int f = 0; f < floors; ++f) {
    			for (int r = 0; r < rows; ++r) {
    				String line = kb.nextLine().trim();
    				for (int c = 0; c < cols; ++c) {
    					char ch = line.charAt(c);
    					maze[r][c][f] = ch;
    					
    					if (ch == kCellStart) {
    						startPos = new MathVector(r, c, f);
    					}
    					else if (ch == kCellExit) {
    						exitPos = new MathVector(r, c, f);
    					}
    				}
    			}
    		}
    		
    		int moves = recurse(startPos);
    		if (moves == 0) {
    			System.out.println("STUCK");
    		}
    		else {
    			System.out.print(moves);
    			System.out.println(" MOVES");
    		}
    	}
    }
}
