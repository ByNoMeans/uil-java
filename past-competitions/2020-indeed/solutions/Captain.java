import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Captain {

	public static void main(String[] args) throws Throwable {
		Scanner kb = new Scanner(new File("captain.dat"));
		while(kb.hasNext())
		{
			String[] s = kb.nextLine().split("\\s+");
			int n = Integer.parseInt(s[0]);
			for(int x = 1; x < s.length; x++)
			{
				n^=Integer.parseInt(s[x]);
			}
			System.out.println(n == 0 ? "Quill is our glorious captain!": "Thor is our glorious captain!");
		}
	}
}