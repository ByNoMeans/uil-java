import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class MultChoice {
	
	public static String[] tokenify(String str) {
		String ret = str.replaceAll("and", ",");
		ret = ret.replaceAll("\\.", ",");
		return ret.split(",");
	}
	
	public static boolean isWithin(String[] first, String[] within) {
		boolean bWithin = true;
		for (int i = 1; i < first.length; ++i) {
			boolean bFound = false;
			for (int j = 1; j < within.length; ++j) {
				if (first[i].trim().equalsIgnoreCase(within[j].trim()))
					bFound = true;
			}
			
			bWithin = bWithin && bFound;
		}
		
		return bWithin;
	}
	
	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("multchoice.dat"));
		
		int count = Integer.parseInt(kb.nextLine().trim());
		for (int x = 0; x < count; ++x) {
			String A = kb.nextLine().trim();
			String[] ATok = tokenify(A);
			
			String B = kb.nextLine().trim();
			String[] BTok = tokenify(B);
			
			String C = kb.nextLine().trim();
			String[] CTok = tokenify(C);
			
			String D = kb.nextLine().trim();
			String[] DTok = tokenify(D);
			
			String E = kb.nextLine().trim();
			String[] ETok = tokenify(E);
			
			System.out.printf("Question %d\n", x + 1);
			if (isWithin(ATok, BTok) || isWithin(ATok, CTok) || isWithin(ATok, DTok) || isWithin(ATok, ETok)) {
				System.out.printf("%s only\n", A);
			}
			else {
				System.out.println(A);
			}
			
			if (isWithin(BTok, ATok) || isWithin(BTok, CTok) || isWithin(BTok, DTok) || isWithin(BTok, ETok)) {
				System.out.printf("%s only\n", B);
			}
			else {
				System.out.println(B);
			}
			
			if (isWithin(CTok, ATok) || isWithin(CTok, BTok) || isWithin(CTok, DTok) || isWithin(CTok, ETok)) {
				System.out.printf("%s only\n", C);
			}
			else {
				System.out.println(C);
			}
			
			if (isWithin(DTok, ATok) || isWithin(DTok, BTok) || isWithin(DTok, CTok) || isWithin(DTok, ETok)) {
				System.out.printf("%s only\n", D);
			}
			else {
				System.out.println(D);
			}
			
			if (isWithin(ETok, ATok) || isWithin(ETok, BTok) || isWithin(ETok, CTok) || isWithin(ETok, DTok)) {
				System.out.printf("%s only\n", E);
			}
			else {
				System.out.println(E);
			}
			
			System.out.println();
		}
	}
}
