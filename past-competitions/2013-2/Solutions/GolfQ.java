import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class GolfQ {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("golfq.dat"));
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		times++;		
		int scores[] = new int[count];		//create array to store scores

		for(int i=0; i<count; i++) {
			String line = kb.nextLine();	
			scores[i]=Integer.parseInt(line.substring(line.length() - 3));
		}
		Arrays.sort(scores);
		
		int cutoff = scores[11];		// scores less than or equal to cutoff will qualify for final round
		kb.close();
		kb = new Scanner(new File("golfq.dat"));	// reread the file
		String dummy = kb.nextLine();  // read the number of lines
		for(int i=0; i<count; i++) {
			String line = kb.nextLine();
			int score = Integer.parseInt(line.substring(line.length() - 3));
			if(score <= cutoff)
				out.println(line.substring(0, line.length() - 4));
		}		
	}	
}
