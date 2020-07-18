import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Waitlist {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("waitlist.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			String contest = s[0];
			int max = Integer.parseInt(s[1]);
			int reg = Integer.parseInt(s[2]);
			int diff = reg - max;
			out.print(contest + " ");
			if(diff < 0)
				out.println(0);
			else 
				out.println(diff);	
		}
	}	
}
