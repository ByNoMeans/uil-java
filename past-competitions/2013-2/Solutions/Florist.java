import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class Florist {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("florist.dat"));
		String []wts = kb.nextLine().trim().split(" ");
		int[]weights = new int[wts.length];
		for(int i=0; i<wts.length; i++) 
				weights[i] = Integer.parseInt(wts[i]);
		Arrays.sort(weights);
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []plnts = t.split(" ");
			int plants[] = new int[plnts.length];
			for(int i=0; i<plants.length; i++) 
				plants[i] = Integer.parseInt(plnts[i]);
			Arrays.sort(plants);
						
			int ok=0, i=0, j=0;
			while(i<plants.length && j<weights.length) {
				int p = plants[i];
				int w = weights[j];
					
				if(p <= w) {
					ok++;
					i++;
					j++;
				}
				else
					j++;
			}
			out.println(ok);	
		}
	}	
}
