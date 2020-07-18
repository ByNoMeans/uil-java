import java.io.*;
import java.util.*;
import static java.lang.System.*;  


import java.util.Map;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;


public class Bouncing {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("bouncing.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;
			String t = kb.nextLine().trim();
					
			Random rand = new Random(Long.parseLong(t));	
 			String top = "WHITE";
 			String left = "BLUE";
 			String front = "RED";
 			
			int numTurns = rand.nextInt(10) + 1;		// number of times it changes direction

														//remove // on next line to print random number generated
														//out.println("numTurns " + numTurns);			
														
			for(int i=0; i<numTurns; i++) {
				int dir = rand.nextInt(4) + 1;			// direction of roll
				int numTimes = rand.nextInt(5) + 1;		// number of times it rolls
				
														//remove // on next line to print random number generated
														//out.println("   dir " + dir + "   numTimes " + numTimes);	
																
				//numTimes is even, color stay the same
				//numTimes is odd, color changes
				//dir=1 or dir=2 ==> roll forward or backward
				//dir=3 or dir=4 ==> roll left or right
	
				if(numTimes % 2 == 1)
					if(dir==1 || dir==2){		//forward or backward
						String temp = top;
						top = front;
						front = temp;
					}
					else {						//left or right
						String temp = top;
						top = left;
						left = temp;
					}	
			}				
			out.println(top);	
		}
	}	
}
