import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Moose {
	
	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("moose.dat"));
		
		int count = Integer.parseInt(kb.nextLine().trim());
		for (int x = 0; x < count; ++x) {
			char[][] mat = new char[10][10];
			for (int i = 0; i < 10; ++i) {
				String s = kb.nextLine().trim();
				for (int j = 0; j < 10; ++j) {
					mat[i][j] = s.charAt(j);
				}
			}
			
			int maxMoosen = 0;
			for (int i = 0; i < 10; ++i) {
				for (int j = 0; j < 10; ++j) {
					int moosen = recurse(mat, i, j);
					if (moosen > maxMoosen) {
						maxMoosen = moosen;
					}
				}
			}
			
			System.out.println(maxMoosen);
		}
	}

	public static int recurse(char[][] mat, int r, int c) {
		if (r < 0 || r >= 10) {
			return 0;
		}
		
		if (c < 0 || c >= 10) {
			return 0;
		}
		
		if (mat[r][c] != 'M') {
			return 0;
		}
		
		mat[r][c] = ' ';
		int count = 1;
		
		count += recurse(mat, r - 1, c);
		count += recurse(mat, r + 1, c);
		
		count += recurse(mat, r, c - 1);
		count += recurse(mat, r, c + 1);

		return count;
	}
}
