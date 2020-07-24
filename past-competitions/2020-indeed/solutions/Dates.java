import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class Dates {

	public static void main(String[] args) throws Throwable
	{
		Scanner kb = new Scanner(new File("dates.dat"));
		int times = kb.nextInt();
		kb.nextLine();
		while(times-->0)
		{
			String[] s = kb.nextLine().split("/");
			long n = kb.nextLong();
			kb.nextLine();
			LocalDate ld = LocalDate.of(Integer.parseInt(s[2]), Integer.parseInt(s[0]), Integer.parseInt(s[1]));
			ld = ld.plusDays(n);
			System.out.printf("%02d/%02d/%04d%n",ld.getMonth().getValue(),ld.getDayOfMonth(),ld.getYear());
		}
	}
}