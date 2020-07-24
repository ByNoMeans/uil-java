import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {
	public static void main(String[] args) throws Throwable
	{
		Scanner kb = new Scanner(new File("words.dat"));
		String[] s = kb.nextLine().replaceAll("[0-9]+", "").split(" ");
		for(int x = 0; x < s.length; x++)
		{
			String temp = s[x];
			String out = "";
			String punc = "";
			for(int z = temp.length()-1; z >= 0; z--)
			{
				if(Character.isAlphabetic(temp.charAt(z)))
				{
					out+=temp.charAt(z);
				}
				else
				{
					punc+=temp.charAt(z);
				}
			}
			System.out.print(out+punc+" ");
		}
	}
}
