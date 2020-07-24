import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chances {

	public static void main(String[] args) throws Throwable {
		Scanner kb = new Scanner(new File("chances.dat"));
		int times = kb.nextInt();
		
		while(times-->0)
		{
			double percent = kb.nextDouble();
			long possible = kb.nextLong();
			System.out.println((long)(Math.round(percent/100*possible)));
		}
	}
}