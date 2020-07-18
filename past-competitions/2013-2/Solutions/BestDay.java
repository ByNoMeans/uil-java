import java.io.*;
import java.util.*;
import static java.lang.System.*;  


public class BestDay {

	public static void main(String args[]) throws IOException
	{
		Scanner kb = new Scanner(new File("bestday.dat"));
		
		int times = 0; 
		int count = Integer.parseInt(kb.nextLine().trim());
		while(times < count) {
			times++;		

			String t = kb.nextLine().trim();
			String []s = t.split(" ");
			int most = Integer.parseInt(s[0]);
			int day = 0;
			for(int i=1; i<7; i++) {
				int next = Integer.parseInt(s[i]);
				if (next > most) {
					most=next;
					day=i;
				}
			}
			switch (day) {
				case 0: out.println("SUNDAY"); break;
				case 1: out.println("MONDAY"); break;
				case 2: out.println("TUESDAY"); break;
				case 3: out.println("WEDNESDAY"); break;
				case 4: out.println("THURSDAY"); break;
				case 5: out.println("FRIDAY"); break;
				case 6: out.println("SATURDAY"); break;
			}
		}
	}

}
